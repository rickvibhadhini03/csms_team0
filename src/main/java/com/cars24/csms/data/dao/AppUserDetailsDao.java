package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;

public interface AppUserDetailsDao {
    String getUserDetails(LoginReq loginReq);
    boolean existUser(String username);
    String createUser(SignUpReq signupUserRequest);
}
