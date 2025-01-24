package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppUserDetailsDao;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Slf4j
@Validated
@Service
public class AppUserDetailsDaoImpl implements AppUserDetailsDao {

    private final AppUserRepository appUserRepository;

    public AppUserDetails getUserAppUserDetails(LoginReq loginReq){
        AppUserDetails details= appUserRepository.findAppUserDetailsByNameAndPassword(loginReq.getName(), loginReq.getPassword());
        log.info("[getUserAppUserDetails] {}", loginReq);
        return details;
    }
}
