package com.crud.mapper;
import com.crud.model.dto.ReceitaCreateDTO;
import com.crud.model.dto.ReceitaDTO;
import com.crud.model.Receita;
import com.crud.model.dto.ReceitaListDTO;
import com.crud.model.dto.ReceitaUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ReceitaMapper extends GenericMapper<
        ReceitaDTO, ReceitaCreateDTO, ReceitaUpdateDTO, ReceitaListDTO, Receita, Long> {
    ReceitaMapper INSTANCE = Mappers.getMapper(ReceitaMapper.class);


    ReceitaDTO toDTO(Receita receita);

    @Mapping(target = "id", ignore = true)
    Receita toEntity(ReceitaDTO receitaDTO);
}
