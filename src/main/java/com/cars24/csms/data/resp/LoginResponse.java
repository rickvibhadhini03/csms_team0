package com.cars24.csms.data.resp;

import lombok.Data;

@Data
public class LoginResponse {

    private String username;
    private String password;
    private int id;
}
