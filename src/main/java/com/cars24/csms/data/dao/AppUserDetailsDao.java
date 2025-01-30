package com.cars24.csms.data.dao;

<<<<<<< HEAD
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.req.LoginReq;
=======
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
import org.springframework.stereotype.Service;

@Service
public interface AppUserDetailsDao {
<<<<<<< HEAD
    public AppUserDetails getAppUser(LoginReq loginReq);
    //public boolean findUserByUsername(String username);
    boolean userExists(String username);
    void saveUser(AppUserDetails user);


}

=======
    String getUserDetails(LoginReq loginReq);
    void RegisterUser(SignUpReq signUpRequest);
    Boolean checkIfUserExists(SignUpReq signUpRequest);

}
>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
