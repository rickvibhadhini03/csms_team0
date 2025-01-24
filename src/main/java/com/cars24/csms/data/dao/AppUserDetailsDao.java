package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;

public interface AppUserDetailsDao {

    public AppUserDetails getAppUserDetails(LoginReq loginRequest) ;
    public void createUser(SignUpReq signUpRequest);

}
