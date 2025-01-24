package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUserDetails,Integer> {
    public AppUserDetails findByUsernameAndPassword(String username, String password);
    public boolean existsByUsername(String username);
}
