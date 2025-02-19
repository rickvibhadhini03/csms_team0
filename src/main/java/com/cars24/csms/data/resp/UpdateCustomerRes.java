package com.cars24.csms.data.resp;

import lombok.Data;

@Data
public class UpdateCustomerRes {
    private String phone;
    private String name;
    private String email;
    private String address;
}
