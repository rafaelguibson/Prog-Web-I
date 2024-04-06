package com.crud.dto;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ReceitaDTO {
    private String nome;
    private String ingredientes;
    private String modoPreparo;
    private int tempoPreparo;
    private String rendimento;
    private int categoria;
}