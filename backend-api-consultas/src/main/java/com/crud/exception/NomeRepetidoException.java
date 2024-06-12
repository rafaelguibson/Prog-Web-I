package com.crud.exception;

public class NomeRepetidoException extends RuntimeException {
    public NomeRepetidoException(String nomeReceita) {
        super("Já existe uma receita com o nome: " + nomeReceita);
    }
}
