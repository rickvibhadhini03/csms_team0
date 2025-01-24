package com.cars24.csms.data.resp;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ApiResponse {
    private int StatusCode;
    private boolean Success;
    private String Message;
    private String service;
    private Object data;
}
