package com.crud.service;



import com.crud.model.GenericModel;

import java.util.List;

public interface CrudService<
        MODEL extends GenericModel<TYPE_PK>, TYPE_PK
        > {
    List<MODEL> listAll();
    MODEL create(MODEL dado);
    MODEL update(MODEL dado);

    MODEL getById(TYPE_PK id);

    MODEL deleteById(TYPE_PK id);
}
