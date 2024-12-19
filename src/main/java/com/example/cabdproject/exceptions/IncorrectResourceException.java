package com.example.cabdproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class IncorrectResourceException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public IncorrectResourceException(String message) {
        super(message);
    }
}
