//package com.cars24.csms.data.req;
//
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotBlank;
//import lombok.Data;
//
//@Data
//public class LoginRequest {
//    @Valid
//    @NotBlank
//    private String username;
//
//    @Valid
//    @NotBlank
//    private String password;
//}













package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Valid
@Data
public class LoginReq {

    @Valid
    @NotBlank(message = "Username cannot be blank")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Invalid email format"
    )
    private String username;

    @Valid
    @NotBlank(message = "Password cannot be blank")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, contain one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    private String password;
}
