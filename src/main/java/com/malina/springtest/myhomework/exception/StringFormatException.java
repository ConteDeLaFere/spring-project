package com.malina.springtest.myhomework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StringFormatException extends RuntimeException  {
    public StringFormatException(String message) {
        super(message);
    }
}
