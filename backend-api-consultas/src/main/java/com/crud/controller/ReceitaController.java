package com.crud.controller;

import com.crud.mapper.ReceitaMapper;
import com.crud.model.Receita;
import com.crud.model.dto.ReceitaCreateDTO;
import com.crud.model.dto.ReceitaDTO;
import com.crud.model.dto.ReceitaListDTO;
import com.crud.model.dto.ReceitaUpdateDTO;
import com.crud.service.ReceitaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/receitas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReceitaController extends
GenericCRUDController<
        ReceitaDTO, // DTO Geral
        ReceitaCreateDTO, // DTO Create
        ReceitaUpdateDTO, // DTO Update
        ReceitaListDTO,
        Receita, // Modelo
        Long, // PK_TYPE
        ReceitaService, //Interface Serviço
        ReceitaMapper> // Mapper
{

}
