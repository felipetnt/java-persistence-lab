package org.example.DAO;

import java.lang.reflect.Field;

public class Column {
    private String nome;
    private String tipo;

    public Column(String nome, String tipo){
        setNome(nome);
        setTipo(tipo);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
