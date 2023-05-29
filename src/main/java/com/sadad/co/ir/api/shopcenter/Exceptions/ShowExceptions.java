package com.sadad.co.ir.api.shopcenter.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class ShowExceptions {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime dateTime;

    public ShowExceptions(String message, HttpStatus httpStatus, ZonedDateTime dateTime) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.dateTime = dateTime;
    }
}
