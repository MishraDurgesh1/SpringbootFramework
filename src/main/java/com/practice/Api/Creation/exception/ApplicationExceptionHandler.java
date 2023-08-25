package com.practice.Api.Creation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler( value = {ApplicationNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException
            (ApplicationNotFoundException applicationNotFoundException){
        ApplicationException applicationException =new ApplicationException(
                applicationNotFoundException.getMessage(),
                applicationNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(applicationException,HttpStatus.NOT_FOUND);
    }
}
