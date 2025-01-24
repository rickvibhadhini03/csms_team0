package com.cars24.csms.data.resp;

import com.cars24.csms.data.entities.CustomerEntity_r1;
import com.cars24.csms.data.entities.ServiceEntity_r1;
import com.cars24.csms.data.entities.VehicleEntity_r1;
import lombok.Data;

@Data
public class GetAppointmentsResponse {
    private CustomerEntity_r1 customerId;
    private VehicleEntity_r1 vehicleId;
    private ServiceEntity_r1 serviceId;
    private String appointmentDate;
    private String status;

    public CustomerEntity_r1 getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerEntity_r1 customerId) {
        this.customerId = customerId;
    }

    public VehicleEntity_r1 getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(VehicleEntity_r1 vehicleId) {
        this.vehicleId = vehicleId;
    }

    public ServiceEntity_r1 getServiceId() {
        return serviceId;
    }

    public void setServiceId(ServiceEntity_r1 serviceId) {
        this.serviceId = serviceId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
