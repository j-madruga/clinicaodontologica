package com.clinica.odontologica.dao;

import java.util.List;

public interface IDao<T> {
    T save(T t);
    T findById(Long id);
    List<T> findAll();
    T updateName(Long id, String newName);
    void delete(Long id);
}
