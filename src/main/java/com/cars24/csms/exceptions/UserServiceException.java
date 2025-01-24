package com.cars24.csms.exceptions;

public class UserServiceException extends RuntimeException{

    UserServiceException(String message){
        super(message);
    }
}
