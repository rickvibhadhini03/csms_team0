//package com.cars24.csms.controllers;
//
//import com.cars24.csms.data.dao.AppUserDao;
//import com.cars24.csms.data.dao.AppUserDetailsDaoImpl;
//import com.cars24.csms.data.entities.AppUserDetails;
//import com.cars24.csms.data.req.LoginRequest;
//import com.cars24.csms.data.req.SignUpRequest;
//import com.cars24.csms.data.res.LoginResponse;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/users")
//@Validated
//@Service
//@Slf4j
//@RequiredArgsConstructor
//
//public class AppUserDetailsController {
//
//    private final AppUserDetailsDaoImpl appUserDetailsDaoImpl;
//    @GetMapping()
//    public ResponseEntity<LoginResponse> getappuserdetails(@Valid @RequestBody LoginRequest loginRequest){
//        LoginResponse loginResponse = new LoginResponse();
//        AppUserDetails appUserDetails = new AppUserDetails();
//        appUserDetails = appUserDetailsDaoImpl.getAppUserDetails(loginRequest);
//
//        loginResponse.setUsername(appUserDetails.getUsername());
//        loginResponse.setPassword(appUserDetails.getPassword());
//
//        return ResponseEntity.ok().body(loginResponse);
//    }
//
//    @PostMapping("/signup")
//    public String createUser(@Valid @RequestBody SignUpRequest signupRequest){
//        log.info(signupRequest.getUsername());
//        log.info(signupRequest.getPassword());
//
//        return appUserDetailsDaoImpl.createUser(signupRequest);
//    }
//
//
//}

























package com.cars24.csms.controllers;


import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.data.resp.LoginResponse;
import com.cars24.csms.services.impl.AppUserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Validated
@Slf4j
@Service
@RequiredArgsConstructor

public class AppUserDetailsController {

    private final AppUserServiceImpl appUserServiceImpl;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getUser(@Valid @RequestBody LoginReq loginRequest){

        LoginResponse loginResp = appUserServiceImpl.getAppUserDetails(loginRequest);
        return ResponseEntity.ok().body(loginResp);
        //return null;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody SignUpReq signupRequest){
        log.info(signupRequest.getUsername());
        log.info(signupRequest.getPassword());
        log.info("[createUser] createUser {}", signupRequest);
        return appUserServiceImpl.createUser(signupRequest);


    }



}
