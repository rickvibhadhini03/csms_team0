package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entites.AppUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AppUserRepository extends JpaRepository<AppUserDetails,Integer> {
    public AppUserDetails findUserDetailsByUsernameAndPassword(String username, String password);
    public boolean existsByUsername(String username);
    AppUserDetails findByUsername(String username);
}
