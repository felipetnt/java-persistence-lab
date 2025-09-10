package org.example.DAO;

import java.util.List;

public interface DAO<T> {
    public void persistir(T obj);
    public List<T> selectAll();
}
