package com.github.gabrielburich.invoicereports.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class APIError {

    private final Integer code;
    private final String message;
    private final LocalDateTime date;

    public APIError(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.message = message;
        this.date = LocalDateTime.now();
    }
}
