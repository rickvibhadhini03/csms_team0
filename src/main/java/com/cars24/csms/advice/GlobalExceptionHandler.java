//package com.cars24.csms.advice;
//
//
//import com.cars24.csms.data.res.ApiResponse;
//import com.cars24.csms.exceptions.UserServiceExceptions;
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
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException exception)
//    {
//
//        ApiResponse resp = new ApiResponse();
//
//        log.info("[handleValidationExceptions]");
//
//        Map<String,String> errorMap=new HashMap<>();
//        exception.getBindingResult().getFieldErrors().forEach(error->
//        {
//            errorMap.put(error.getField(),error.getDefaultMessage());
//        });
//        log.info("[handleValidationExceptions] errorMap {}", errorMap);
//
//
//        resp.setStatuscode(HttpStatus.OK.value());
//        resp.setSuccess(true);
//        resp.setMessage("Invalid signup data");
//        resp.setService("APPUSR - " + HttpStatus.OK.value());
//        resp.setData(errorMap);
//
//        return ResponseEntity.badRequest().body(resp);
////        return errorMap;
//    }
//
//
//    @ExceptionHandler(UserServiceExceptions.class)
//    public ResponseEntity<ApiResponse> handleUserServiceExceptions(MethodArgumentNotValidException exception){
//
//        ApiResponse resp = new ApiResponse();
//        resp.setStatuscode(HttpStatus.OK.value());
//        resp.setSuccess(false);
//        resp.setMessage("User already exists");
//        resp.setService("APPUSR - " + HttpStatus.OK.value());
//        resp.setData(null);
//
//        return ResponseEntity.badRequest().body(resp);
//    }
//}
































package com.cars24.csms.advice;


import com.cars24.csms.data.resp.ApiResponse;
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
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        log.info("[handleValidationExceptions]");

        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });

        ApiResponse resp = new ApiResponse();

        resp.setStatuscode(HttpStatus.BAD_REQUEST.value());
        resp.setSuccess(false);
        resp.setMessage("Invalid signup data");
        resp.setService("APPUSR - " + HttpStatus.BAD_REQUEST.value());
        resp.setData(errorMap);

        return ResponseEntity.badRequest().body(resp);

    }


}
