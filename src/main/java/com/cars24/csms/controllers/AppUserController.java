package com.cars24.csms.controllers;

import com.cars24.csms.data.dao.impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.req.LoginReq;

import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;

import com.cars24.csms.services.AppUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/authentication")
@Validated
@Slf4j
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;
    private final AppUserDetailsDaoImpl userDetailsDao;

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginReq loginReq) {
        userDetailsDao.getUserDetails(loginReq);
        log.info("[User controller]: {}", loginReq);
        return;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> appUserSignup(@Valid @RequestBody SignUpReq signupReq){
        return appUserService.createUser(signupReq);

    }
}
