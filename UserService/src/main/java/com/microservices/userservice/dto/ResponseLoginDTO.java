package com.microservices.userservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class ResponseLoginDTO {
    public String message;
    private String statusCode;
    private Object object;
    private Object objectModel;

    public ResponseLoginDTO(String message, String statusCode, Object object, Object objectModel) {
        this.message = message;
        this.statusCode = statusCode;
        this.object = object;
        this.objectModel = objectModel;
    }

    public ResponseLoginDTO(Object object){
        this.object = object;
    }
}