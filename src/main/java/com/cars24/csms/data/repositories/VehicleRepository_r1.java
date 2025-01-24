package com.cars24.csms.data.repositories;


import com.cars24.csms.data.entities.VehicleEntity_r1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository_r1 extends JpaRepository<VehicleEntity_r1, Integer>{
}
