package com.microservices.notesservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.microservices.notesservice.dto.ResponseDTO;

@ControllerAdvice
@Slf4j
public class FundooGlobalException {

    @ExceptionHandler(NoteException.class)
    public ResponseEntity<ResponseDTO> userExceptionHandler(NoteException noteException) {
        log.error("Exception Occurred : " +noteException.exceptionType.errorMsg);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(noteException.exceptionType.errorMsg,
                null,null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LabelException.class)
    public ResponseEntity<ResponseDTO> NoteResponseHandler(LabelException labelException) {
        log.error("Exception Occurred : " +labelException.exceptionType.errorMsg);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(labelException.exceptionType.errorMsg,
                null,null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CollabaretorException.class)
    public ResponseEntity<ResponseDTO> CollabaretorResponseHandler(CollabaretorException collabException) {
        log.error("Exception Occurred : " +collabException.exceptionType.errorMsg);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(collabException.exceptionType.errorMsg,
                null,null), HttpStatus.BAD_REQUEST);
    }

}
