package com.crud.model.dto;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaListDTO {
    private Long id;
    private String nome;
    private String ingredientes;
    private String modoPreparo;
    private int tempoPreparo;
    private String rendimento;
    private int categoria;
}