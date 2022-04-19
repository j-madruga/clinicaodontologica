package com.clinica.odontologica.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler extends Exception{
    private static final Logger LOGGER = LogManager.getLogger("com.log4j2.clinic");
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allErrors(Exception ex, WebRequest req){
        LOGGER.error(ex.getMessage());
        return new ResponseEntity("Error " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
