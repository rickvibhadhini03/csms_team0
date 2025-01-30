package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.ServiceEntity_r1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository_r1 extends JpaRepository<ServiceEntity_r1, Integer>{
}
