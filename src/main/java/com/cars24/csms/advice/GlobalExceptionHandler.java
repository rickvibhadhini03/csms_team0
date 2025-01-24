//package com.cars24.csms.advice;
//
//import com.cars24.csms.data.resp.ApiResponse;
//import com.cars24.csms.exceptions.UserServiceException;
//import jakarta.validation.ValidationException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//@Slf4j
//
//public class GlobalExceptionHandler {
//    ApiResponse ar=new ApiResponse();
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
//        log.info("[handleValidationExceptions]");
//
//        Map<String, String> errorMap = new HashMap<>();
//        exception.getBindingResult().getFieldErrors().forEach(error -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });
//
//        return ResponseEntity.badRequest().body(errorMap);
//    }
//
//    @ExceptionHandler(UserServiceException.class)
//    public ResponseEntity<ApiResponse> handleUserServiceExceptions(UserServiceException exception) {
//        log.error("[handleUserServiceExceptions] Exception occurred: {}", exception.getMessage());
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setStatus(HttpStatus.CONFLICT.value());
//        apiResponse.setSuccess(false);
//        apiResponse.setMessage(exception.getMessage());
//        apiResponse.setService("APPUSR-" + HttpStatus.CONFLICT.value());
//        apiResponse.setData(null);
//
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
//    }
//
//
//}

package com.cars24.csms.advice;

import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException exception ) {
        log.info("[handleValidationExceptions]");

        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
        {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        ApiResponse apiResponse = new ApiResponse();
        // Add your user creation logic here

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("invalid data");
        apiResponse.setService("APPUSR-"+HttpStatus.OK.value());
        apiResponse.setData(errorMap);
        return ResponseEntity.badRequest().body(apiResponse);



    }

    //@ExceptionHandler(MethodArgumentNotValidException.class)
    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceException(UserServiceException exception) {
        //ApiRes apiResponse = new ApiRes();

        // Add your user creation logic here
        ApiResponse apiRespons = new ApiResponse();
        apiRespons.setStatus(HttpStatus.BAD_REQUEST.value());
        apiRespons.setSuccess(false);
        apiRespons.setMessage(exception.getMessage());
        apiRespons.setService("APPUSR-"+HttpStatus.OK.value());
        apiRespons.setData(null);
        return ResponseEntity.badRequest().body(apiRespons);

    }
}