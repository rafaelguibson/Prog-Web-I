package com.crud.mapper;
import com.crud.model.dto.ReceitaDTO;
import com.crud.model.Receita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceitaMapper {
    ReceitaMapper INSTANCE = Mappers.getMapper(ReceitaMapper.class);


    ReceitaDTO toDTO(Receita receita);

    @Mapping(target = "id", ignore = true)
    Receita toEntity(ReceitaDTO receitaDTO);
}
