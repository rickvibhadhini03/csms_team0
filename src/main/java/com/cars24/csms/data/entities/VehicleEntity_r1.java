package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class VehicleEntity_r1 {
    @Id
    @Column(name = "vehicle_id", nullable = false)
    private Integer VehicleId;


}
