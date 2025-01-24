package com.cars24.csms.services.impl;

import com.cars24.csms.exceptions.InvoiceServiceException;
import com.cars24.csms.data.dao.InvoiceDao;
import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.CreateInvoiceResponse;
import com.cars24.csms.data.resp.GetInvoiceResponse;
import com.cars24.csms.services.InvoiceServices;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceServices {

    private final InvoiceDao invoiceDao;

    @Transactional
    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest createInvoiceRequest) {
        log.info("[createInvoice] Validating appointment ID: {}", createInvoiceRequest.getAppointment_id());

        // Validate if the appointment ID exists in the database
        boolean appointmentExists = invoiceDao.checkAppointmentId(createInvoiceRequest.getAppointment_id());
        if (!appointmentExists) {
            log.error("[createInvoice] Appointment ID does not exist: {}", createInvoiceRequest.getAppointment_id());
            throw new InvoiceServiceException("Appointment ID does not exist");
        }
        else {

            log.info("[createInvoice] Appointment ID validated. Creating invoice...");
            int invoiceId = invoiceDao.createInvoice(createInvoiceRequest);

            // Construct and return the response
            CreateInvoiceResponse response = new CreateInvoiceResponse();
            //response.setInvoiceId(invoiceId); // Assuming invoice ID is returned by DAO
            response.setAppointment_id(createInvoiceRequest.getAppointment_id());
            response.setAmount(createInvoiceRequest.getAmount());
            response.setStatus(createInvoiceRequest.getStatus());

            log.info("[createInvoice] Invoice created successfully with ID: {}", invoiceId);
            return response;
        }
    }

    /**
     * Retrieves an invoice by appointment ID.
     *
     * @param appointment_id the appointment ID
     * @return GetInvoiceResponse
     */
    @Override
    public GetInvoiceResponse getInvoiceByAppointmentId(int appointment_id) {
        log.info("[getInvoiceByAppointmentId] Fetching invoice for appointment ID: {}", appointment_id);

        // Fetch the invoice using the DAO
        Optional<GetInvoiceResponse> optionalInvoice = invoiceDao.getInvoiceByAppointmentId(appointment_id);

        if (optionalInvoice.isEmpty()) {
            log.error("[getInvoiceByAppointmentId] No invoice found for appointment ID: {}", appointment_id);
            throw new InvoiceServiceException("No invoice found for appointment ID: " + appointment_id);
        }
         //return invoiceDao.get();

        // Construct and return the response
        GetInvoiceResponse response = optionalInvoice.get();
        log.info("[getInvoiceByAppointmentId] Invoice fetched successfully for appointment ID: {}", appointment_id);

        return response;
    }

    /**
     * Deletes an invoice by appointment ID.
     *
     * @param appointment_id the appointment ID
     */
    @Override
    public void deleteInvoice(int appointment_id) {
        log.info("[deleteInvoice] Deleting invoice for appointment ID: {}", appointment_id);

        // Validate if the appointment ID exists in the database
        boolean appointmentExists = invoiceDao.checkAppointmentId(appointment_id);
        if (!appointmentExists) {
            log.error("[deleteInvoice] Appointment ID does not exist: {}", appointment_id);
            throw new InvoiceServiceException("Appointment ID does not exist: " + appointment_id);
        }

        // Delete the invoice
        invoiceDao.deleteInvoiceByAppointmentId(appointment_id);
        log.info("[deleteInvoice] Invoice deleted successfully for appointment ID: {}", appointment_id);
    }
}
