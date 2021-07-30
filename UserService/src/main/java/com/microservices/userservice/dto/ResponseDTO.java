package com.microservices.userservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseDTO {

    public String message;
    private String statusCode;
    private Object fullname;
    private Object object;

    public ResponseDTO(String message, String statusCode, Object object) {
        this.message = message;
        this.statusCode = statusCode;
        this.object = object;
    }

    public ResponseDTO(Object object){
        this.object = object;
    }

    public ResponseDTO(String message,Object object) {
        this.message = message;
        this.object = object;
    }


    public ResponseDTO(String message, String statusCode,  Object object,Object fullname) {
        this.message=message;
        this.statusCode=statusCode;
        this.object=object;
        this.fullname=fullname;
    }
}
