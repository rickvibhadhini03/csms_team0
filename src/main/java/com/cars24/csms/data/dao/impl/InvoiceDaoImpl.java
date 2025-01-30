package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.InvoiceDao;
import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.repositories.InvoiceRepository;
import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.GetInvoiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

//import static com.cars24.csms.data.enums.InvoiceStatus.UNPAID;
@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceDaoImpl implements InvoiceDao  {
    //@Autowired
     private final InvoiceRepository ir;
     private final AppointmentRepository ar;
     //private final InvoiceRepository ir2;
    @Override
    public boolean checkAppointmentId(int appointmentId){
        log.info("[checkAppointmentId] Validating appointment ID: {}", appointmentId);
        return ar.existsById(appointmentId);
    }
    @Override
    public int createInvoice(CreateInvoiceRequest createInvoiceRequest) {

        log.info("[createInvoice] Creating invoice for appointment ID: {}", createInvoiceRequest.getAppointment_id());

        // Create a new InvoiceEntity
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setAppointment_id(createInvoiceRequest.getAppointment_id());
        invoiceEntity.setAmount(createInvoiceRequest.getAmount());
        invoiceEntity.setStatus(createInvoiceRequest.getStatus());

        // Save to the database and return the generated invoice ID
        InvoiceEntity savedEntity = ir.save(invoiceEntity);
        log.info("[createInvoice] Invoice created with ID: {}", savedEntity.getId());
        return savedEntity.getId();
    }

    @Override
    public Optional<GetInvoiceResponse> getInvoiceByAppointmentId(int appointment_id) {
        // Fetch the InvoiceEntity using repository and map it directly to GetInvoiceResponse
        return ir.findByAppointmentIdCustom(appointment_id)
                .map(invoiceEntity -> {
                    GetInvoiceResponse response = new GetInvoiceResponse();
                    response.setAmount(invoiceEntity.getAmount());
                    response.setStatus(invoiceEntity.getStatus());
                    return response;
                });
    }
    @Override
    public void deleteInvoiceByAppointmentId(int appointment_id) {
        // Find the invoice by appointment_id
        InvoiceEntity invoiceEntity = ir.findByAppointmentIdCustom(appointment_id)
                .orElseThrow(() -> new IllegalArgumentException("Invoice not found for appointment id: " + appointment_id));

        ir.delete(invoiceEntity);  // Delete the invoice entity
    }
}
