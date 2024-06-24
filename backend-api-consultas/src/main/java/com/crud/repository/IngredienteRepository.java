package com.crud.repository;
import com.crud.model.Ingrediente;
import com.crud.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    Optional<Ingrediente> findById(Long id);
}
