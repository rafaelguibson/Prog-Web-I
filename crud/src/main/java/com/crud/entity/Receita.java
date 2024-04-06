package com.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "receita")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "ingredientes", nullable = false)
    private String ingredientes;

    @Column(name = "modoPreparo", nullable = false)
    private String modoPreparo;

    @Column(name = "tempoPreparo", nullable = false)
    private LocalTime tempoPreparo;

    @Column(name = "rendimento", nullable = false)
    private String rendimento;

    @Column(name = "categoria", nullable = false)
    private int categoria;
}
