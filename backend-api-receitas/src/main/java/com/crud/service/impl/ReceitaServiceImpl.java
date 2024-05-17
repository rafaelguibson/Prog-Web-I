package com.crud.service.impl;

import com.crud.exception.MandatoryException;
import com.crud.exception.RendimentoInvalidoException;
import com.crud.exception.TempoPreparoInvalidoException;
import com.crud.model.Receita;
import com.crud.repository.ReceitaRepository;
import com.crud.service.ReceitaService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReceitaServiceImpl extends GenericCrudService<Receita, Long, ReceitaRepository> implements ReceitaService {



    @Override
    protected void prepareToCreate(Receita dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Receita dado) {
        if(dado.getTempoPreparo() <= 0) {
            throw new TempoPreparoInvalidoException();
        }
        if(Objects.isNull(dado.getRendimento()) ||dado.getRendimento().isEmpty() || dado.getRendimento().isBlank()) {
            throw new RendimentoInvalidoException();
        }
    }

    @Override
    protected void validateBusinessLogicForUpdate(Receita dado) {

    }

    @Override
    protected void validateBusinessLogic(Receita dado) {

    }

    @Override
    protected void validateMandatoryFields(Receita dado) {
        if(
                Strings.isEmpty(dado.getNome())
        ){
            throw new MandatoryException("Campos obrigatórios não preenchidos");
        }
    }
}
