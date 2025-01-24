package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppUserDetailsDao;
import com.cars24.csms.data.entites.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserDetailsDaoImpl implements AppUserDetailsDao {
    private final AppUserRepository userRepository;

    @Override
    public String getUserDetails(LoginReq loginUserRequest) {
//         LoginUserResponse loginUserResponse= new LoginUserResponse();
        AppUserDetails userDetailsEntity=userRepository.findUserDetailsByUsernameAndPassword(loginUserRequest.getUsername(),loginUserRequest.getPassword());
        log.info("[App user Details] :{}", userDetailsEntity);
        return "";
    }

    public boolean existUser(String username)
    {
//        ObjectMapper mapper=new ObjectMapper();
        boolean isExists=userRepository.existsByUsername(username);
//        UserDetailsEntity userDetailsEntity=mapper.convertValue(signupUserRequest, UserDetailsEntity.class);
//        userDetailsEntity.setActive(true);
//        userRepository.save(userDetailsEntity);
        log.info("[User exists or not]: {}",username);
        return isExists;

    }

    @Override
    public String createUser(SignUpReq signupUserRequest) {
        log.info("[createUser] IN DAO");
        ObjectMapper objectMapper = new ObjectMapper();
        AppUserDetails userDetailsEntity = objectMapper.convertValue(signupUserRequest, AppUserDetails.class);
        userDetailsEntity.setEnabled(true);
//        userDetailsEntity.setUserType(UserType.CUSTOMER);

        userRepository.save(userDetailsEntity);

        return "";
    }

    public int getUserId(String username)
    {
        AppUserDetails userDetailsEntity=userRepository.findByUsername(username);
        int userId=userDetailsEntity.getId();
        log.info("[get userId] in Dao: {}",userId);
        return userId;

    }
}