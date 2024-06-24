package com.crud.service.impl;


import com.crud.exception.DataException;
import com.crud.exception.MandatoryException;
import com.crud.mapper.GenericUpdateMapper;
import com.crud.model.GenericModel;
import com.crud.model.Ingrediente;
import com.crud.model.Receita;
import com.crud.service.CrudService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class GenericCrudService<
            MODEL extends GenericModel<TYPE_PK>,
            TYPE_PK,
            REPOSITORY extends JpaRepository<MODEL, TYPE_PK>
        > implements CrudService<
                    MODEL,
                    TYPE_PK
                > {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private GenericUpdateMapper<MODEL, TYPE_PK> mapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected REPOSITORY repository;
    public List<MODEL> listAll(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public MODEL create(MODEL dado) {
        prepareToCreate(dado);
        validateMandatoryFields(dado);
        validateBusinessLogic(dado);
        validateBusinessLogicForInsert(dado);
        // Caso específico para Receita
        if (dado instanceof Receita) {
            Receita receita = (Receita) dado;

            // Validar ingredientes
            if (CollectionUtils.isEmpty(receita.getIngredientes())) {
                throw new MandatoryException("A receita deve ter ingredientes.");
            }

            // Validar lógica de negócio para ingredientes, se necessário

            // Salvar ingredientes associados à receita
            for (Ingrediente ingrediente : receita.getIngredientes()) {
                ingrediente.setReceita(receita);
            }
        }
        return repository.save(dado);
    }

    protected abstract void prepareToCreate(MODEL dado);

    @Override
    public MODEL update(MODEL dataToUpdate){
        var dataDB = validateIdModelExists(dataToUpdate.getId());
        validateMandatoryFields(dataToUpdate);
        validateBusinessLogic(dataToUpdate);
        validateBusinessLogicForUpdate(dataToUpdate);
        updateDataDBFromUpdate(dataToUpdate, dataDB);
        return repository.save(dataDB);
    }

    protected void updateDataDBFromUpdate(MODEL dataToUpdate, MODEL dataDB){
        mapper.updateModelFromModel(dataDB, dataToUpdate);
    };

    @Override
    public MODEL getById(TYPE_PK id){
        return this.validateIdModelExists(id);
    }

    @Override
    public MODEL deleteById(TYPE_PK id){
        MODEL modelToRemove = this.validateIdModelExists(id);
        this.repository.delete(modelToRemove);
        return modelToRemove;
    }

    private MODEL validateIdModelExists(TYPE_PK id){
        boolean valid = true;
        MODEL dadoBD = null;

        if(Objects.nonNull(id)) {
            dadoBD = this.internalGetById(id);
            if (dadoBD == null) {
                valid = false;
            }
        }else{
            valid = false;
        }

        if(Boolean.FALSE.equals(valid)){
            //MODEL.class.getSimpleName()
            throw new DataException("Objeto não existe");
        }
        return dadoBD;
    }

    private MODEL internalGetById(TYPE_PK id){
        Optional<MODEL> byId = repository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    protected abstract void validateBusinessLogicForInsert(MODEL dado);

    protected abstract void validateBusinessLogicForUpdate(MODEL dado) ;

    protected abstract void validateBusinessLogic(MODEL dado) ;

    protected abstract void validateMandatoryFields(MODEL dado);
}
