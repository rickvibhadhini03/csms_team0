package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginReq;
import org.springframework.stereotype.Service;

@Service
public interface AppUserDetailsDao {
    public AppUserDetails getAppUser(LoginReq loginReq);
    //public boolean findUserByUsername(String username);
    boolean userExists(String username);
    void saveUser(AppUserDetails user);


}

