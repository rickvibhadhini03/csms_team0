package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginReq {
    @Valid
    @NotBlank(message = "username cannot be blank!")
    private String username;

    @Valid
    @NotBlank(message = "password cannot be blank!")
    private String password;
}
