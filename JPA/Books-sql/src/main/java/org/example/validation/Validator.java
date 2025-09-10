package org.example.validation;

import org.example.annotation.NotEmpty;
import org.example.annotation.NotNull;
import org.example.exception.ValidationException;
import java.lang.reflect.Field;

public class Validator {
    public static void validateEntity(Object obj) {
        Class<?> clazz = obj.getClass();

        Field[] campos = clazz.getDeclaredFields();

        for (Field campo : campos) {
            campo.setAccessible(true);
            Object valor;
            try {
                valor = campo.get(obj);
            } catch (IllegalAccessException e) {
                throw new ValidationException("Erro ao acessar o campo " + campo.getName());
            }

            if (campo.isAnnotationPresent(NotNull.class)) {
                if (valor == null) {
                    NotNull notNull = campo.getAnnotation(NotNull.class);
                    throw new ValidationException(notNull.message());
                }
            }

            if (campo.isAnnotationPresent(NotEmpty.class)) {
                if (valor instanceof String && ((String) valor).isEmpty()) {
                    NotEmpty notEmpty = campo.getAnnotation(NotEmpty.class);
                    throw new ValidationException(notEmpty.message());
                }
            }
        }
    }
}
