package com.crud.exception;
public class ReceitaNaoEncontradaException extends RuntimeException {
    public ReceitaNaoEncontradaException() {
        super("A receita não foi encontrada.");
    }
}

