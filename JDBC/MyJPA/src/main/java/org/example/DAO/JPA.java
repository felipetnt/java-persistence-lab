package org.example.DAO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

interface JPA {
    public void persistir(Object obj);
    public <T> List<T> buscarTodos(Class<T> clazz);
    public String getType(Field campo);
}
