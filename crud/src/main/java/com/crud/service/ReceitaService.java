package com.crud.service;
import com.crud.dto.ReceitaDTO;
import com.crud.entity.Receita;
import com.crud.exception.*;
import com.crud.mapper.ReceitaMapper;
import com.crud.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    @Transactional
    public Receita salvar(ReceitaDTO receitaDTO) {
        validarCampos(receitaDTO);
        Receita receita = ReceitaMapper.INSTANCE.toEntity(receitaDTO);
        return receitaRepository.save(receita);
    }

    @Transactional
    public Receita atualizar(Long id, ReceitaDTO receitaDTO) {
        validarCampos(receitaDTO);
        Receita receitaExistente = buscarPorId(id);
        receitaExistente.setNome(receitaDTO.getNome());
        receitaExistente.setIngredientes(receitaDTO.getIngredientes());
        receitaExistente.setModoPreparo(receitaDTO.getModoPreparo());
        receitaExistente.setTempoPreparo(receitaDTO.getTempoPreparo());
        receitaExistente.setRendimento(receitaDTO.getRendimento());
        receitaExistente.setCategoria(receitaDTO.getCategoria());
        return receitaRepository.save(receitaExistente);
    }

    @Transactional(readOnly = true)
    public Receita buscarPorId(Long id) {
        Optional<Receita> optionalReceita = receitaRepository.findById(id);
        if (optionalReceita.isEmpty()) {
            throw new ReceitaNaoEncontradaException();
        }
        return optionalReceita.get();
    }

    @Transactional(readOnly = true)
    public List<Receita> listarTodos() {
        return receitaRepository.findAll();
    }

    @Transactional
    public void excluir(Long id) {
        Receita receita = buscarPorId(id);
        receitaRepository.delete(receita);
    }

    private void validarCampos(ReceitaDTO receitaDTO) {
        if (receitaDTO.getNome() == null || receitaDTO.getNome().isEmpty()) {
            throw new NomeInvalidoException();
        }
        if (receitaDTO.getIngredientes() == null || receitaDTO.getIngredientes().isEmpty()) {
            throw new IngredientesInvalidosException();
        }
        if (receitaDTO.getTempoPreparo() < 0) {
            throw new TempoPreparoInvalidoException();
        }
        if (receitaDTO.getRendimento().isEmpty()) {
            throw new RendimentoInvalidoException();
        }
    }
    public ReceitaDTO toDTO(Receita receita) {
        return ReceitaMapper.INSTANCE.toDTO(receita);
    }
}

