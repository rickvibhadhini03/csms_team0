package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.AppointmentDaoImpl;
import com.cars24.csms.data.entities.AppointmentEntities_r1;
import com.cars24.csms.data.entities.CustomerEntity_r1;
import com.cars24.csms.data.entities.ServiceEntity_r1;
import com.cars24.csms.data.entities.VehicleEntity_r1;
import com.cars24.csms.data.repositories.AppointmentRepository_r1;
import com.cars24.csms.data.repositories.CustomerRepository_r1;
import com.cars24.csms.data.repositories.ServiceRepository_r1;
import com.cars24.csms.data.repositories.VehicleRepository_r1;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.req.UpdateAppointmentRequest;
import com.cars24.csms.data.resp.CreateAppointmentResponse;
import com.cars24.csms.data.resp.GetAppointmentsResponse;
import com.cars24.csms.services.AppointmentServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentServiceImpl implements AppointmentServices {

    private final AppointmentDaoImpl appointmentDao;
    private final AppointmentRepository_r1 appointmentRepository;
    private final CustomerRepository_r1 customerRepository;
    private final VehicleRepository_r1 vehicleRepositoryR;
    private final ServiceRepository_r1 serviceRepository;

    @Override
    public CreateAppointmentResponse createAppointment(CreateAppointmentRequest request) {
        // Call the DAO to create and save the appointment entity
        log.info("[createAppointment] createAppointmentsRequest: ", request);

        CustomerEntity_r1 customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (customer == null) {
            log.error("[createAppointment] Customer with ID {} not found", request.getCustomerId());
            // Handle the error (e.g., throw an exception, return an error response, etc.)
            return null;
        }

        VehicleEntity_r1 vehicle = vehicleRepositoryR.findById(request.getVehicleId()).orElse(null);
        if (vehicle == null) {
            log.error("[createAppointment] Customer with ID {} not found", request.getCustomerId());
            // Handle the error (e.g., throw an exception, return an error response, etc.)
            return null;
        }

        ServiceEntity_r1 service = serviceRepository.findById(request.getServiceId()).orElse(null);
        if (service == null) {
            log.error("[createAppointment] Service with ID {} not found", request.getServiceId());
            // Handle the error
            return null;
        }
        appointmentDao.createAppointment(request);
       log.info("[createAppointment] {}",request);
       return null;
    }

    @Override
    public void updateAppointment(int appointmentId, UpdateAppointmentRequest updateRequest){
        // Check if appointment exists

        AppointmentEntities_r1 existingAppointment = appointmentDao.findById(appointmentId)
                .orElseThrow(() -> new NoSuchElementException("Appointment with ID " + appointmentId + " does not exist."));

        // Update only the allowed fields
        if (updateRequest.getAppointmentDate() != null) {
            existingAppointment.setAppDate(String.valueOf(updateRequest.getAppointmentDate()));
        }
        if (updateRequest.getStatus() != null) {
            existingAppointment.setStatus(String.valueOf(updateRequest.getStatus()));
        }

        // Save the updated entity
        appointmentDao.save(existingAppointment);
    }
    public List<GetAppointmentsResponse> getAppointments(Integer customerId){
        return appointmentDao.getAppointments(customerId);
    }
//    @Override
//    public List<CreateAppointmentResponse> getAppointmentsByDate(String date) {
//        return appointmentDao.getAppointmentsByDate(date);
//    }
    @Override
    public void deleteAppointment(int appointmentId) {
        if (!appointmentDao.existsById(appointmentId)) {
            throw new NoSuchElementException("Appointment with ID " + appointmentId + " does not exist.");
        }
        appointmentDao.deleteAppointment(appointmentId);
    }
    @Override
    public void deactivateAppointment(int appointmentId) {
        AppointmentEntities_r1 appointment = appointmentDao.findById(appointmentId)
                .orElseThrow(() -> new NoSuchElementException("Appointment with ID " + appointmentId + " does not exist."));

        // Set the appointment as inactive
        appointment.setIsActive(0);
        appointmentDao.save(appointment);
    }



}
