package com.crud.service;


import com.crud.model.Receita;

import java.util.List;

public interface ReceitaService extends CrudService<Receita, Long>{
     List<Receita> listAllSorted();
}
