package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppointmentEntities_r1;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.resp.GetAppointmentsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentDao {
    int createAppointment(CreateAppointmentRequest request);
    //List<CreateAppointmentResponse> getAppointmentsByDate(String date);
    List<GetAppointmentsResponse> getAppointments(Integer customerId);
    Optional<AppointmentEntities_r1> findById(int appointmentId);
    void save(AppointmentEntities_r1 appointment);
    void deleteAppointment(int appointmentId);
    boolean existsById(int appointmentId);
}
