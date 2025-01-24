package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
@Data
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", nullable = false, unique = true)
    private int appointmentId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "vehicle_id", nullable = false)
    private int vehicleId;

    @Column(name = "service_id", nullable = false)
    private int serviceId;

    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "status", nullable = false)
    private String status;
}
