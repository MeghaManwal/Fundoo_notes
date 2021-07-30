package com.microservices.userservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@NoArgsConstructor
@Getter
@Setter
public class UserLoginDTO {
	
    @Pattern(regexp = "^[A-Z a-z 0-9]+([._+-][0-9 a-z A-Z]+)*@[0-9 a-z A-Z]+.[a-z A-Z]{2,3}([.][a-z A-Z]{2})*$",message = "please do enter the valid email id" )
    @NotNull(message = "Please Do Enter email id!")
    @NotEmpty(message = "Please Do Enter email id!")
    public String emailID;

    @Pattern(regexp = "^(?=[0-9 A-Z a-z !@#$%^&*();:]{8,}$)(?=.*[A-Z]{1,})(?=.*[0-9]{1,})(?=.*[!@#$%^&*();:]{1,}).*$", message = "please enter correct password")
    @NotNull(message = "Please Do Enter Password!")
    @NotEmpty(message = "Please Do  Enter Password!")
    public String password;

    public UserLoginDTO(String emailID, String password) {
        this.emailID = emailID;
        this.password = password;
    }
}