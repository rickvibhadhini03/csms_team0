package com.cars24.csms.controller;

import com.cars24.csms.data.dao.impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.services.impl.AppUserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Validated
@Slf4j
@RestController
@RequestMapping("users")
public class AppUserController {
    private final AppUserDetailsDaoImpl adi;
    private final AppUserServiceImpl asi;

    @GetMapping("/login")
    public ResponseEntity<AppUserDetails> getUserAppUserDetails(@Valid @RequestBody LoginReq loginReq){
        AppUserDetails app= adi.getUserAppUserDetails(loginReq);
        log.info("[LoginRequest]");
        return ResponseEntity.ok(app);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> userSignUp(@Valid @RequestBody SignUpReq signUpReq){
        log.info("[userSignUp] {}");
        return asi.signUpUser(signUpReq);
    }
}
