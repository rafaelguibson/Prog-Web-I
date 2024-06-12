package com.crud.model.dto;
import lombok.*;

import java.time.LocalTime;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaDTO {
    private String nome;
    private String ingredientes;
    private String modoPreparo;
    private int tempoPreparo;
    private String rendimento;
    private int categoria;
}