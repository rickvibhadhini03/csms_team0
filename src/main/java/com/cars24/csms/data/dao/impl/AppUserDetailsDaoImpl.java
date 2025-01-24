package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppUserDetailsDao;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserDetailsDaoImpl implements AppUserDetailsDao {

    private final AppUserRepository appUserRepository;
    ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public String getAppUserDetails(LoginReq loginReq) {
        AppUserDetails details=appUserRepository.findByUsernameAndPassword(loginReq.getUsername(), loginReq.getPassword());
        log.info("result:{}",details);
        return " ";
    }

    public boolean userExists(String username) {
        boolean isexists=appUserRepository.existsByUsername(username);
        log.info("User esists {}", isexists);
        return isexists;
    }

    @Override
    public String createUser(SignUpReq signUpReq) {
        AppUserDetails appUserDetails = objectMapper.convertValue(signUpReq,AppUserDetails.class);
        appUserDetails.setEnable(true);
//        appUserDetails.setUsername(appUserReq.getUsername());
//        appUserDetails.setPassword(appUserReq.getPassword());
//        appUserDetails.setEnable(true); // assuming default is 'true'
        appUserRepository.save(appUserDetails);
        return "";
    }
}
