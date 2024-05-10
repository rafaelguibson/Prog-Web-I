package com.crud.exception;
public class RendimentoInvalidoException extends RuntimeException {
    public RendimentoInvalidoException() {
        super("O rendimento não pode estar vazio.");
    }
}