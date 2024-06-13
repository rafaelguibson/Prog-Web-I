package com.crud.controller;

import com.crud.mapper.ReceitaMapper;
import com.crud.model.Receita;
import com.crud.model.dto.ReceitaCreateDTO;
import com.crud.model.dto.ReceitaDTO;
import com.crud.model.dto.ReceitaListDTO;
import com.crud.model.dto.ReceitaUpdateDTO;
import com.crud.service.ReceitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/receitas")
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
