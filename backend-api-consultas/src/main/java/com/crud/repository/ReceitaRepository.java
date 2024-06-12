package com.crud.repository;
import com.crud.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    Optional<Receita> findByNome(String nome);
}
