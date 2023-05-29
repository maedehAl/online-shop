package com.sadad.co.ir.api.shopcenter.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class BaseBusinessExceptionHandler {


    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<Object> InvalidIdExceptions(BaseException exception) {

        ShowExceptions showExceptions = new ShowExceptions(
                exception.getMessage(),
                exception.getHttpStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(showExceptions,  exception.getHttpStatus());
    }
}