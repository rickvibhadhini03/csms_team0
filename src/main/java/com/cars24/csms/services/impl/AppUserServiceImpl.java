package com.cars24.csms.services.impl;

<<<<<<< HEAD
import com.cars24.csms.data.entities.AppUserDetails;
=======
import com.cars24.csms.data.dao.Impl.AppUserDetailsDaoImpl;
>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.AppUserService;
<<<<<<< HEAD
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
=======
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
<<<<<<< HEAD
        private final AppUserRepository ari; // Repository for user persistence
        private final ObjectMapper mapper;  // For converting request to entity

        @Override
        public ResponseEntity<ApiResponse> signUpUser(SignUpReq signUpReq) {
            log.info("Checking if user already exists: {}", signUpReq.getName());

            // Check if the user exists
            if (ari.existsByName(signUpReq.getName())) {
                // Throw exception if the user exists
                throw new UserServiceException("User with name '" + signUpReq.getName() + "' already exists.");
            }

            // Map the sign-up request to AppUserDetails entity
            AppUserDetails newUser = mapper.convertValue(signUpReq, AppUserDetails.class);

            // Save the user to the database
            newUser.setId(0);
            AppUserDetails savedUser = ari.save(newUser);
            return null;

        }
}
=======
    private final AppUserDetailsDaoImpl appUserDao;
    private final AppUserRepository appUserRepository;


    public ResponseEntity<ApiResponse> signUp(SignUpReq signUpRequest) {
        ApiResponse apiResponse = new ApiResponse();
        log.info("[signUp] IN SERVICE : {} ",signUpRequest);
        if (appUserDao.checkIfUserExists(signUpRequest)) {
            //if exists
            throw new UserServiceException("User already exists");
        } else {
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("User signed up successfully");
            apiResponse.setService("APPUSR-" + HttpStatus.OK.value());
            apiResponse.setData(null);

            appUserDao.RegisterUser(signUpRequest);

            return ResponseEntity.ok().body(apiResponse);
        }

    }
}







>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
