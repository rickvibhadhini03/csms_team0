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

    //any errors like validation or verification errors while taking an input then we directly go to GlobalException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        log.info("[handleValidationExceptions]");

        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });

        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("Validation failed");
        apiResponse.setService("APPUSER "+HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(errorMap);
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceExceptions(UserServiceException exception)
    {
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage("Invalid signUp data");
        apiResponse.setService("APPUSER "+HttpStatus.BAD_REQUEST.value());
        //apiResponse.setData(null);
        return ResponseEntity.ok().body(apiResponse);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidDateFormat(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }




}
