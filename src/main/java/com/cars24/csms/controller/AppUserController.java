package com.cars24.csms.controller;


import com.cars24.csms.data.dao.impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.services.impl.AppUserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
@Service
@Slf4j
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserDetailsDaoImpl appUserDao;
    private final AppUserServiceImpl appUserService;

    @GetMapping("/login")
    public ResponseEntity<ApiResponse> getUserDetails(@RequestBody @Valid LoginReq loginReq){
        String res=appUserDao.getAppUserDetails(loginReq);
        log.info("Logging in {}",res);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Login successful");
        apiResponse.setService("APPUSER " + HttpStatus.OK.value());
        apiResponse.setData(res);

        return ResponseEntity.ok(apiResponse);
        //return "";
    }
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> appUserSignUp(@RequestBody @Valid SignUpReq signUpReq){

        log.info("Attempting to sign up user: {}", signUpReq.getUsername());
        return appUserService.signUpUser(signUpReq);

    }

}
