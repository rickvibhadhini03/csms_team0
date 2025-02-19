package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.req.UpdateAppointmentRequest;
import com.cars24.csms.data.resp.CreateAppointmentResponse;
import com.cars24.csms.data.resp.GetAppointmentsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentServices {
    CreateAppointmentResponse createAppointment(CreateAppointmentRequest request);
    //List<CreateAppointmentResponse> getAppointmentsByDate(String date);
    List<GetAppointmentsResponse> getAppointments(Integer customerId);
    void updateAppointment(int appointmentId, UpdateAppointmentRequest updateRequest);
    void deleteAppointment(int appointmentId);
    public void deactivateAppointment(int appointmentId);
}
