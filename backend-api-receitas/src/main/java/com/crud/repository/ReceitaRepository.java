package com.crud.repository;
import com.crud.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    Receita findByNome(String nome);
}
