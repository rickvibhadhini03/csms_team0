package com.cars24.csms.data.resp;

import lombok.Data;

@Data
public class ApiResponse {

    private int statuscode;
    private boolean success;
    private String message;
    private Object data;

    private String service;

}
