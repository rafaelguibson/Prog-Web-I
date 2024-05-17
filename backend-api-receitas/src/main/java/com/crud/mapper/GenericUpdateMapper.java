package com.crud.mapper;


import com.crud.model.GenericModel;
import org.mapstruct.MappingTarget;

public interface GenericUpdateMapper<
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > {
    void updateModelFromModel(@MappingTarget MODEL entity, MODEL updateEntity);
}
