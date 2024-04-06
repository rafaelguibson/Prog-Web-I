package com.crud.dto;
import lombok.Data;

@Data
public class ReceitaDTO {
    private String nome;
    private String ingredientes;
    private String modoPreparo;
    private int tempoPreparo;
    private int rendimento;
    private int categoria;
}