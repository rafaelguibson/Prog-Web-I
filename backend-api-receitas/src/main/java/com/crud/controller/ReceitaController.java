package com.crud.controller;

import com.crud.model.Receita;
import com.crud.model.dto.ReceitaDTO;
import com.crud.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<Receita> salvar(@RequestBody ReceitaDTO receitaDTO) {
        Receita novaReceita = receitaService.salvar(receitaDTO);
        return new ResponseEntity<>(novaReceita, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizar(@PathVariable Long id, @RequestBody ReceitaDTO receitaDTO) {
        Receita receitaAtualizada = receitaService.atualizar(id, receitaDTO);
        return new ResponseEntity<>(receitaAtualizada, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> buscarPorId(@PathVariable Long id) {
        Receita receita = receitaService.buscarPorId(id);
        ReceitaDTO receitaDTO = receitaService.toDTO(receita);
        return new ResponseEntity<>(receitaDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Receita>> listarTodos() {
        List<Receita> receitas = receitaService.listarTodos();
        return new ResponseEntity<>(receitas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        receitaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
