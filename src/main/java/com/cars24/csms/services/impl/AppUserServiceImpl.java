package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.AppUserDetailsDaoImpl;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.data.resp.LoginResponse;
import com.cars24.csms.services.AppUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserDetailsDaoImpl appUserDaoImpl;

    @Override
    public ResponseEntity<ApiResponse> createUser(SignUpReq signUpRequest) {
        boolean exists=false; //this is to check if the user already exists

        ApiResponse resp = new ApiResponse();

        exists = appUserRepository.existsByUsername(signUpRequest.getUsername());

        if(!exists){
            resp.setStatuscode(HttpStatus.OK.value());
            resp.setSuccess(true);
            resp.setMessage("User signed up successfully");
            resp.setService("APPUSR - " + HttpStatus.OK.value());
            resp.setData(null);

            appUserDaoImpl.createUser(signUpRequest);

            return  ResponseEntity.ok().body(resp);
        }

//        ApiResponse resp = new ApiResponse();
//        resp.setStatuscode(HttpStatus.OK.value());
//        resp.setSuccess(true);
//        resp.setMessage("User signed up successfully");
//        resp.setService("APPUSR - " + HttpStatus.OK.value());
//        resp.setData(null);

        else {
            resp.setStatuscode(HttpStatus.BAD_REQUEST.value());
            resp.setSuccess(false);
            resp.setMessage("User already exists");
            resp.setService("APPUSR - " + HttpStatus.OK.value());
            resp.setData(null);

            return ResponseEntity.ok().body(resp);
        }
//        return ResponseEntity.ok().body(resp);
    }

    public LoginResponse getAppUserDetails(@Valid LoginReq loginRequest) {
        AppUserDetails appUserDetails = appUserDaoImpl.getAppUserDetails(loginRequest);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(appUserDetails.getId());
        loginResponse.setUsername(appUserDetails.getUsername());

        return loginResponse;
    }


}
