package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppUserDetailsDao;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Repository
@RequiredArgsConstructor
public class AppUserDaoDetailsImpl implements AppUserDetailsDao {
    private final AppUserRepository apr;


    public AppUserDetails getAppUser(LoginReq loginReq){
      // String
        //String Password;
        AppUserDetails appUserdetails=apr.findAppUserDetailsByUsernameAndPassword(loginReq.getUsername(), loginReq.getPassword());
        return null;



    }
    @Override
    public boolean userExists(String username) {
        return apr.existsByUsername(username); // username represents email
    }
    @Override
    public void saveUser(AppUserDetails user){
        apr.save(user);
    }

}
