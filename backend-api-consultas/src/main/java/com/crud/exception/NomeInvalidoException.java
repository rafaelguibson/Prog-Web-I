package com.crud.exception;

public class NomeInvalidoException extends RuntimeException {
    public NomeInvalidoException() {
        super("Nome da receita inválido!");
    }
}