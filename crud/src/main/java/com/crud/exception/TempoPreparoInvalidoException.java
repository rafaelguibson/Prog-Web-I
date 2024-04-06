package com.crud.exception;
public class TempoPreparoInvalidoException extends RuntimeException {
    public TempoPreparoInvalidoException() {
        super("O tempo de preparo não pode ser negativo.");
    }
}