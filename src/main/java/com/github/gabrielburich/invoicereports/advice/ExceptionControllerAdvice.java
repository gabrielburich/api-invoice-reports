package com.github.gabrielburich.invoicereports.advice;

import com.github.gabrielburich.invoicereports.exception.NotFoundException;
import com.github.gabrielburich.invoicereports.util.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<APIError> notFoundAdvice(NotFoundException exception) {
        var status = HttpStatus.NOT_FOUND;
        var apiError = new APIError(status, exception.getMessage());
        return ResponseEntity.status(status).body(apiError);
    }

}
