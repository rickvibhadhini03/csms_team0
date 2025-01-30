package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.ServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServicesRepository extends JpaRepository<ServicesEntity,Integer> {

}