package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entites.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity,Integer> {
    Optional<CustomerEntity> getByPhone(String phone);
    void deleteByPhone(String phone);
}
