package com.crud.exception;
public class IngredientesInvalidosException extends RuntimeException {
    public IngredientesInvalidosException() {
        super("O campo de ingredientes não pode estar vazia.");
    }
}