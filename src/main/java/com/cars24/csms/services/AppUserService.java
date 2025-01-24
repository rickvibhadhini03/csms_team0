package com.cars24.csms.services;

import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    public ApiResponse createUser(SignUpReq signUpReq);
    //boolean validateUser(String username);
}
