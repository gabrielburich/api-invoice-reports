package com.github.gabrielburich.invoicereports.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(Class<?> entity, String id) {
        this("Could not find an " + entity.getSimpleName() + " with id = " + id);
    }
}
