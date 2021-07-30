package com.microservices.userservice.services;

import org.springframework.stereotype.Service;

import com.microservices.userservice.dto.UserLoginDTO;
import com.microservices.userservice.dto.UserRegistrationDTO;
import com.microservices.userservice.model.UserDetailsModel;

import javax.mail.MessagingException;
import java.util.List;


public interface IUserService {
    UserDetailsModel addUser(UserRegistrationDTO userDetails);

    void verifyEmail(String tokenId);

    UserDetailsModel userLogin(UserLoginDTO userLoginDTO);

    String resetPasswordLink(String emailID) throws MessagingException;

    String resetPassword(String password, String urlToken);

    List<UserDetailsModel> getUserInformation(String token);

    UserDetailsModel setUserDetails(String token);
}
