package com.cars24.csms.data.req;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.Data;

@Data
public class SignUpReq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Valid
    private int appid;
    @Valid
    private int is_active;
    @Valid
    private String name;
    @Valid
    private String password;

}
