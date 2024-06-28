package com.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RECEITA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receita implements GenericModel<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao", nullable = false, unique = true, length = 10000)
    private String descricao;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Ingrediente> ingredientes;

    @Column(name = "modoPreparo", nullable = false, length = 10000)
    private String modoPreparo;

    @Column(name = "tempoPreparo", nullable = false)
    private int tempoPreparo;

    @Column(name = "rendimento", nullable = false)
    private String rendimento;

    @Column(name = "categoria", nullable = false)
    private int categoria;

    @Column(updatable = false)
    private Date dataCadastro;

    @PrePersist
    protected void onCreate() {
        dataCadastro = new Date();
    }
}
