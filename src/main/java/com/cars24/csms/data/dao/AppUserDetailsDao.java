package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginReq;
import org.springframework.stereotype.Service;

@Service
public interface AppUserDetailsDao {
     AppUserDetails getUserAppUserDetails(LoginReq loginReq);

}
