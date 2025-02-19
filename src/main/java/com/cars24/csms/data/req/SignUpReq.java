package com.cars24.csms.data.req;

<<<<<<< HEAD
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data

public class SignUpReq {
    @NotBlank(message ="Username is required.")
    @Email(message="invalid email format.")
    private String username;
    @NotBlank(message="password is required.")
    @Length(min=2,max=20,message="Password must be between 2 and 20 chars")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!])[\\w@#$%^&+=!]{2,20}$", message = "Password must be 2-20 characters long, include at least one letter, one digit, and one special character.")
    private String password;



=======
import lombok.Data;

@Data
public class SignUpReq {
    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String name;
    String password;
>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
}
