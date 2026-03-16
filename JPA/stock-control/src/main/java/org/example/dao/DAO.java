package org.example.dao;

import java.util.List;
import java.util.UUID;

public interface DAO<T> {
    void persistir(T entity);
    T search(UUID id);
    List<T> listAll();
    void delete(T entity);
}
