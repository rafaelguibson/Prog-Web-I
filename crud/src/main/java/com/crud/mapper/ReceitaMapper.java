package com.crud.mapper;
import com.crud.dto.ReceitaDTO;
import com.crud.entity.Receita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceitaMapper {
    ReceitaMapper INSTANCE = Mappers.getMapper(ReceitaMapper.class);

    @Mapping(target = "categoria", ignore = true)
    ReceitaDTO toDTO(Receita receita);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    Receita toEntity(ReceitaDTO receitaDTO);
}
