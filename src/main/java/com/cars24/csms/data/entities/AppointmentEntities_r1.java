package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data

@jakarta.persistence.Table(name="appointments")
@jakarta.persistence.Entity
public class AppointmentEntities_r1 {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name = "appointment_id", nullable = false)
    private Integer appointmentId;

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity_r1 customerId;

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity_r1 vehicleId;

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "service_id", nullable = false)
    private ServiceEntity_r1 serviceId;

    @jakarta.persistence.Column(name = "appointment_date", nullable = false)
    private String appDate;

    @jakarta.persistence.Column(name = "status", length = 50)
    private String status;

    @Column(name = "active")
    private Integer isActive;

}
