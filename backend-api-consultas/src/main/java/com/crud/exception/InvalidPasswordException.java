package com.crud.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("Senha Incorreta !");
    }
}