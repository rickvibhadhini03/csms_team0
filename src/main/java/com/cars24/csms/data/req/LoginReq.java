package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginReq {


    @Valid
    @NotNull
    private String name;

    @Valid
    @NotNull
    private String password;

}
