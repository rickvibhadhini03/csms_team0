package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.resp.GetInvoiceResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface InvoiceDao {
    public int createInvoice(CreateInvoiceRequest createInvoiceRequest);
    public Optional<GetInvoiceResponse> getInvoiceByAppointmentId(int appointment_id);
    //void deleteInvoiceEntity(InvoiceEntity invoiceEntity);
    boolean checkAppointmentId(int appointmentId);
    void deleteInvoiceByAppointmentId(int appointmentId);
}
