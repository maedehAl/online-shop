package com.sadad.co.ir.api.shopcenter.exception;

public class BusinessBaseException extends RuntimeException{

    private String errCode;
    public BusinessBaseException(String message, String errCode){
        super(message);
        this.errCode=errCode;
//control Advice
    }
}
