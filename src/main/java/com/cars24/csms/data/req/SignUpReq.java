package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignUpReq {

    @NotBlank(message = "Username cannot be blank!")
    @Email(message = "Enter a valid Email Id !!")
    private String username;

    @NotBlank(message = "Password cannot be blank!")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()])[A-Za-z\\d!@#$%^&*()]{2,20}$",
            message = "Password must be 2-20 characters long, contain at least one uppercase letter, and one special character (!@#$%^&*()).")
    private  String password;
    private UserType user_type;
}
