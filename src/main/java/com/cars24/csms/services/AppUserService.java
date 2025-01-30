package com.cars24.csms.services;

import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    ResponseEntity<ApiResponse> signUpUser(SignUpReq signUpReq);
=======

public interface AppUserService {
    ResponseEntity<ApiResponse> signUp(SignUpReq signUpRequest);
>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
}
