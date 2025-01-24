package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import org.springframework.stereotype.Service;

@Service
public interface AppUserDetailsDao {
    String getAppUserDetails(LoginReq loginReq);

    String createUser(SignUpReq signUpReq);
}
