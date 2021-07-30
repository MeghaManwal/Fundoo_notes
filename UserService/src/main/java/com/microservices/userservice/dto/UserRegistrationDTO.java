package com.microservices.userservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class UserRegistrationDTO {
	
    @Pattern(regexp = "^[A-Z]{1}[a-z A-Z\\s]{2,}$", message = "please enter valid credentials")
    @NotNull(message = "Please Do Enter valid name!")
    @NotEmpty(message = "Please Enter Valid name!")
    public String fullName;


    @Pattern(regexp = "^[+][0-9]{1,}[1-9]{1}[0-9]{9}$", message = "Please Do Enter Valid Mobile Number!")
    @NotNull(message = "Please Do Enter Valid Mobile Number!")
    @NotEmpty(message = "Please Do Enter Valid Mobile Number!")
    public String phoneNumber;

    @Pattern(regexp = "^[A-Z a-z 0-9]+([._+-][0-9 a-z A-Z]+)*@[0-9 a-z A-Z]+.[a-z A-Z]{2,3}([.][a-z A-Z]{2})*$", message = "please do enter the valid email id")
    @NotNull(message = "Please Do Enter email id!")
    @NotEmpty(message = "Please Do Enter email id!")
    public String emailID;


    @Pattern(regexp = "^(?=[0-9 A-Z a-z !@#$%^&*();:]{8,}$)(?=.*[A-Z]{1,})(?=.*[0-9]{1,})(?=.*[!@#$%^&*();:]{1,}).*$", message = "please enter correct password")
    @NotNull(message = "Please Do Enter Password!")
    @NotEmpty(message = "Please Do  Enter Password!")
    public String password;


    public UserRegistrationDTO(String fullName, String phoneNumber, String emailID, String password) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.password = password;
    }

}
