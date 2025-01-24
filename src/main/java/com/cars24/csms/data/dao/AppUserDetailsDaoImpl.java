package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AppUserDetailsDaoImpl implements AppUserDetailsDao {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUserDetails getAppUserDetails(LoginReq loginRequest) {
        return appUserRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

//    @Override
//    public String createUser(SignUpRequest signUpRequest) {
//        return "";
//    }

    @Override
    public void createUser(SignUpReq signupRequest) {

//        // appUserEntity.setUser_id(10);
//        appUserEntity.setActive(true);
//        appUserEntity.setPassword(signupRequest.getPassword());
//        appUserEntity.setUsername(signupRequest.getUsername());

        ObjectMapper objectMapper = new ObjectMapper();
        AppUserDetails appUserEntity = objectMapper.convertValue(signupRequest , AppUserDetails.class);
        appUserEntity.setIs_enabled(true);

        appUserRepository.save(appUserEntity);

    }

}
