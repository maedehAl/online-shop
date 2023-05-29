package com.sadad.co.ir.api.shopcenter.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
