package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserDetails, Integer> {

    //the integer denotes primary key
    //this is the query method
    public AppUserDetails findAppUserDetailsByUsernameAndPassword(String username, String password);
    public boolean existsByUsername(String username);
}
