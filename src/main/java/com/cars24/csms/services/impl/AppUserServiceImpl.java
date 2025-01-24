package com.cars24.csms.services.impl;

import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
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
