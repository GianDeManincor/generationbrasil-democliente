package com.generation.brasil.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClienteExceptionController {

    @ExceptionHandler(value = ClienteNotFoundException.class)
    public ResponseEntity<Object> exception(ClienteNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(exception.getMessage(), exception.getStatusCode());
        HttpStatus httpStatus = HttpStatus.valueOf(exception.getStatusCode());
        return new ResponseEntity<>(error, httpStatus);
    }
}
