package com.cars24.csms.data.req;

<<<<<<< HEAD
import lombok.Data;

@Data
public class LoginReq {
    private String username;
    private String password;

=======
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NonNull;

@Data
public class LoginReq {
    @Valid
    @NonNull
    private String username;

    @Valid
    @NonNull
    private String password;
>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
}
