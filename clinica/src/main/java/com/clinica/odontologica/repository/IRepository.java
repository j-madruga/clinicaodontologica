package com.clinica.odontologica.repository;

import java.util.List;

public interface IRepository<T> {
    T save(T t);
    T findById(Long id);
    List<T> findAll();
    T updateName(Long id, String newName);
    void delete(Long id);
}
