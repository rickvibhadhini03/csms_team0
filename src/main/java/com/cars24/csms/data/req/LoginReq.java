package com.cars24.csms.data.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginReq {
    @NotBlank(message = "username cannot be left blank")
    @Email
    private String username;

    @NotBlank(message = "password cannot be left blank")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%^&\\*])(?=\\S+$).{8,}$",
            message = "Password must contain at least 1 number, 1 uppercase letter, 1 lowercase letter, 1 special character, and be at least 8 characters long")
    private String password;
}
