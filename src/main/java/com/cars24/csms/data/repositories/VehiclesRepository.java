package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends JpaRepository<VehicleEntity,Integer> {
}
