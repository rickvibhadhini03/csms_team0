package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppointmentDao;
import com.cars24.csms.data.entities.AppointmentEntities_r1;
import com.cars24.csms.data.entities.CustomerEntity_r1;
import com.cars24.csms.data.entities.ServiceEntity_r1;
import com.cars24.csms.data.entities.VehicleEntity_r1;
import com.cars24.csms.data.repositories.AppointmentRepository_r1;
import com.cars24.csms.data.repositories.CustomerRepository_r1;
import com.cars24.csms.data.repositories.ServiceRepository_r1;
import com.cars24.csms.data.repositories.VehicleRepository_r1;
import com.cars24.csms.data.req.CreateAppointmentRequest;
import com.cars24.csms.data.resp.GetAppointmentsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentDaoImpl implements AppointmentDao {
    //@Autowired // spring automatically creates object stores in appointrepo
    private final AppointmentRepository_r1 appointmentRepository;
    private final CustomerRepository_r1 customerRepository;
    private final VehicleRepository_r1 vehicleRepositoryR;
    private final ServiceRepository_r1 serviceRepository;

    @Override
    public int createAppointment(CreateAppointmentRequest request) {

        // Fetch the customer, vehicle, and service entities
        CustomerEntity_r1 customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found for ID: " + request.getCustomerId()));

        VehicleEntity_r1 vehicle = vehicleRepositoryR.findById(request.getVehicleId())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found for ID: " + request.getVehicleId()));

        ServiceEntity_r1 service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new IllegalArgumentException("Service not found for ID: " + request.getServiceId()));

        // Define the format of the input date string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime appointmentDateTime = LocalDateTime.parse(request.getAppointmentDate(), formatter);

        // Create an AppointmentEntities object from the request
        AppointmentEntities_r1 appointmentEntities = new AppointmentEntities_r1();
        appointmentEntities.setCustomerId(customer);
        appointmentEntities.setVehicleId(vehicle);
        appointmentEntities.setServiceId(service);
        appointmentEntities.setAppDate(appointmentDateTime.format(formatter));
        appointmentEntities.setStatus(request.getStatus().name()); // Assuming enum AppointmentStatus

        // Save the AppointmentEntities object to the database
        appointmentRepository.save(appointmentEntities);
        return 0;
//        AppointmentEntities appointmentEntities = new AppointmentEntities();
//        CustomerEntity customer = customerRepository.findById(request.getCustomerId())
//                .orElseThrow(() -> new IllegalArgumentException("Customer not found for ID: " + request.getCustomerId()));
//        appointmentEntities.setCustomerId(customer);
//
//        VehicleEntity vehicle = vehicleRepository.findById(request.getVehicleId())
//                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found for ID: " + request.getVehicleId()));
//        appointmentEntities.setVehicleId(vehicle);
//
//        ServiceEntity service = serviceRepository.findById(request.getServiceId())
//                .orElseThrow(() -> new IllegalArgumentException("Service not found for ID: " + request.getServiceId()));
//        appointmentEntities.setServiceId(service);
//
//
//        // Parse the string to LocalDateTime using the defined formatter
//       // LocalDateTime appointmentDateTime = LocalDateTime.parse(request.getAppointmentDate(),formatter);
//        // Create an AppointmentEntities object from the request
//
//       // appointmentEntities.setAppointmentId(0);
//        appointmentEntities.setCustomerId(request.getCustomerId());
//        appointmentEntities.setVehicleId(request.getVehicleId());
//        appointmentEntities.setServiceId(request.getServiceId());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime appointmentDateTime = LocalDateTime.parse(request.getAppointmentDate(),formatter);
//        appointmentEntities.setAppDate(appointmentDateTime.format(formatter));
//
//        //appointmentEntities.setAppDate(String.valueOf(appointmentDateTime));
//        appointmentEntities.setStatus(request.getStatus().name());  // Assuming AppointmentStatus is an enum
//
//        // Save the AppointmentEntities object to the database
//        appointmentRepository.save(appointmentEntities);
//        return 0;
    }
    public List<GetAppointmentsResponse> getAppointments(Integer customerId){
        log.info("[getAppointments] Fetching appointments for customer ID: {}", customerId);
        List<AppointmentEntities_r1> appointmentsEntities = appointmentRepository.findAll()
                .stream()
                .filter(appointment -> appointment.getCustomerId().getCustomerId().equals(customerId))
                .toList();

        if (appointmentsEntities.isEmpty()) {
            log.error("[getAppointments] No appointments found for customer ID: {}", customerId);
            return null;  // You can return an empty list or null, depending on how you want to handle no results
        }

        // Map the list of AppointmentsEntity to GetAppointmentsResponse
        return appointmentsEntities.stream()
                .map(appointmentsEntity -> {
                    GetAppointmentsResponse response = new GetAppointmentsResponse();

                    // Map the properties from AppointmentsEntity to GetAppointmentsResponse
//                    response.setAppointmentId(appointmentsEntity.getAppointmentId());
                    response.setCustomerId(appointmentsEntity.getCustomerId());  // Assuming CustomerEntity has customerId field
                    response.setVehicleId(appointmentsEntity.getVehicleId());      // Assuming VehicleEntity has vehicleId field
                    response.setServiceId(appointmentsEntity.getServiceId());      // Assuming ServiceEntity has serviceId field
                    response.setAppointmentDate(appointmentsEntity.getAppDate());
                    response.setStatus(appointmentsEntity.getStatus().toString());

                    return response;
                })
                .collect(Collectors.toList());

    }
//    @Override
//    public List<CreateAppointmentResponse> getAppointmentsByDate(String date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate inputDate = LocalDate.parse(date, formatter);
//
//        List<AppointmentEntities> appointmentEntitiesList = appointmentRepository.findAll()
//                .stream()
//                .filter(appointment -> appointment.getAppDate().toLocalDate().equals(inputDate))
//                .collect(Collectors.toList());
//
//        return appointmentEntitiesList.stream()
//                .map(appointment -> {
//                    String formattedDate = appointment.getAppDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//                    AppointmentStatus status = AppointmentStatus.valueOf(appointment.getStatus());
//
//                    return new CreateAppointmentResponse(
//                            appointment.getId(),
//                            appointment.getCustId(),
//                            appointment.getVehId(),
//                            appointment.getSerId(),
//                            formattedDate,
//                            status
//                    );
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public Optional<AppointmentEntities_r1> findById(int appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    @Override
    public void save(AppointmentEntities_r1 appointment) {
        appointmentRepository.save(appointment);
    }


    @Override
    public void deleteAppointment(int appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public boolean existsById(int appointmentId) {
        return appointmentRepository.existsById(appointmentId);
    }

}
