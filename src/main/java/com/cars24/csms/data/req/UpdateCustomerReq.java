package com.cars24.csms.data.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCustomerReq {
    @NotBlank(message = "Phone number is required")
    private String phone;

    private String name;
    private String email;
    private String address;
}
