package com.crud.mapper;
import com.crud.dto.ReceitaDTO;
import com.crud.entity.Receita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReceitaMapper {
    ReceitaMapper INSTANCE = Mappers.getMapper(ReceitaMapper.class);


    ReceitaDTO toDTO(Receita receita);

    @Mapping(target = "id", ignore = true)
    Receita toEntity(ReceitaDTO receitaDTO);
}
