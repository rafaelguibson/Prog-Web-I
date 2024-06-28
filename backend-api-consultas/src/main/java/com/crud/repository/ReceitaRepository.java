package com.crud.repository;
import com.crud.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    Optional<Receita> findByNome(String nome);
    @Query("SELECT r FROM Receita r ORDER BY r.dataCadastro DESC")
    List<Receita> findAllByOrderByDataCadastroDesc();
}
