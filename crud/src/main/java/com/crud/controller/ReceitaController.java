package com.crud.controller;
import com.crud.dto.ReceitaDTO;
import com.crud.entity.Receita;
import com.crud.exception.*;
import com.crud.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<Receita> salvar(@RequestBody ReceitaDTO receitaDTO) {
        try {
            Receita novaReceita = receitaService.salvar(receitaDTO);
            return new ResponseEntity<>(novaReceita, HttpStatus.CREATED);
        } catch (NomeInvalidoException | IngredientesInvalidosException | TempoPreparoInvalidoException | RendimentoInvalidoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizar(@PathVariable Long id, @RequestBody ReceitaDTO receitaDTO) {
        try {
            Receita receitaAtualizada = receitaService.atualizar(id, receitaDTO);
            return new ResponseEntity<>(receitaAtualizada, HttpStatus.OK);
        } catch (ReceitaNaoEncontradaException | NomeInvalidoException | IngredientesInvalidosException |
                 TempoPreparoInvalidoException | RendimentoInvalidoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> buscarPorId(@PathVariable Long id) {
        try {
            Receita receita = receitaService.buscarPorId(id);
            ReceitaDTO receitaDTO = receitaService.toDTO(receita);
            return new ResponseEntity<>(receitaDTO, HttpStatus.OK);
        } catch (ReceitaNaoEncontradaException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Receita>> listarTodos() {
        List<Receita> receitas = receitaService.listarTodos();
        return new ResponseEntity<>(receitas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            receitaService.excluir(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ReceitaNaoEncontradaException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
