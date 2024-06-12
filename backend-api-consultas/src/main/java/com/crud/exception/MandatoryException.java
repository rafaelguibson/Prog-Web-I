package com.crud.exception;

public class MandatoryException extends RuntimeException{
    public MandatoryException(String message, Throwable e){
        super(message, e);
    }
    public MandatoryException(String message){
        super(message);
    }
}
