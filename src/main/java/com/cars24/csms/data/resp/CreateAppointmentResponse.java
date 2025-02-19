package com.cars24.csms.data.resp;

import com.cars24.csms.data.entities.CustomerEntity_r1;
import com.cars24.csms.data.entities.ServiceEntity_r1;
import com.cars24.csms.data.entities.VehicleEntity_r1;
import com.cars24.csms.data.enums.AppointmentStatus;
import lombok.Data;

@Data
public class CreateAppointmentResponse {

    private int appointmentId;

    private CustomerEntity_r1 customerId;

    private VehicleEntity_r1 vehicleId;

    private ServiceEntity_r1 serviceId;

    private String appointmentDate;

    private AppointmentStatus status;

//    public CreateAppointmentResponse(int appointmentId, int customerId, int vehicleId, int serviceId, String appointmentDate, AppointmentStatus status) {
//        this.appointmentId = appointmentId;
//        this.customerId = customerId;
//        this.vehicleId = vehicleId;
//        this.serviceId = serviceId;
//        this.appointmentDate = appointmentDate;
//        this.status = status;
//    }


}
