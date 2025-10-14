package org.example.DAO;

import org.example.models.Author;

import java.util.List;

public interface DAO<T> {
    void persistir(T entity);
    T update(T entity);
    List<T> listAll();

}
