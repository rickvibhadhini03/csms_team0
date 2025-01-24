package com.cars24.csms.data.resp;

import lombok.Data;

@Data
public class LoginResponse {
    private int Id;
    private String username;
    private String message="login Successful";

}
