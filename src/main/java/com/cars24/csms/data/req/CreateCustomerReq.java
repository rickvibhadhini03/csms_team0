package com.cars24.csms.data.req;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

//import javax.validation.Valid;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Min;

@Valid
@Data
public class CreateCustomerReq {

    @Valid
    @Min(value = 1,message = "Invalid Customer Id")
    private int customer_id;

    @Valid
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Valid
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String phone;

    @Valid
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email ;

    @Valid
    @NotBlank(message = "Address is required")
    @Size(max = 200, message = "Address must not exceed 200 characters")
    private String address ;



}
