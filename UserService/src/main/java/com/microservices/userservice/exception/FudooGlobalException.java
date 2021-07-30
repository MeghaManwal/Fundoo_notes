package com.microservices.userservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.microservices.userservice.dto.ResponseDTO;

@ControllerAdvice
@Slf4j
public class FudooGlobalException {


    @ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseDTO> userExceptionHandler(UserException userException) {
        log.error("Exception Occurred : " +userException.exceptionType.errorMsg);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(userException.exceptionType.errorMsg, null,null), HttpStatus.BAD_REQUEST);
    }

}
