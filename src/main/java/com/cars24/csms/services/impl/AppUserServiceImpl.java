package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.AuthenticationFailedException;
import com.cars24.csms.services.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDetailsDaoImpl userDetailsDao;
    @Override
    public ResponseEntity<ApiResponse> createUser(SignUpReq signupReq) {
        boolean res=userDetailsDao.existUser(signupReq.getUsername());

        ApiResponse apiResponse=new ApiResponse();
        if(res) {


            throw new AuthenticationFailedException("User already exists");
        }
        else {
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("User signup successfully");
            apiResponse.setData(null);
            apiResponse.setService("App user - "+HttpStatus.OK.value());
//            apiResponse.setUserType(UserType.CUSTOMER);

            userDetailsDao.createUser(signupReq);
        }
        log.info("[signup]: {}", apiResponse);
        return ResponseEntity.ok().body(apiResponse);




    }


}
