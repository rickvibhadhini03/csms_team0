package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDetailsDaoImpl appUserDao;


    @Override
    public ResponseEntity<ApiResponse> signUpUser(SignUpReq signUpReq) {
        if (appUserDao.userExists(signUpReq.getUsername())) {
            throw new UserServiceException("User already exists");
        }
        ApiResponse apiResponse=new ApiResponse();

        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("User signed up successfully");
        apiResponse.setService("APPUSER "+HttpStatus.OK.value());
        apiResponse.setData(null);
        appUserDao.createUser(signUpReq);
        return ResponseEntity.ok().body(apiResponse);
    }

    @Override
    public boolean existUser(String username) {
        log.info("[Service existUser]: {}",username);
        return appUserDao.userExists(username);
    }
}
