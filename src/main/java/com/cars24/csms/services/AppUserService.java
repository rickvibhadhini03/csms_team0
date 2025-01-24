package com.cars24.csms.services;

import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    ResponseEntity<ApiResponse> signUpUser(SignUpReq signUpReq);
}
