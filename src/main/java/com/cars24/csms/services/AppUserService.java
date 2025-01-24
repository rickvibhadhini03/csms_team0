package com.cars24.csms.services;

import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    //public LoginRes Customerlogin(LoginReq loginReq);
    public ResponseEntity<ApiResponse> createUser(SignUpReq signupReq);
}
