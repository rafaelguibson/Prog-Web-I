package com.crud.model;

public interface GenericModel<TYPE_PK> {
    TYPE_PK getId();
    void setId(TYPE_PK id);
}
