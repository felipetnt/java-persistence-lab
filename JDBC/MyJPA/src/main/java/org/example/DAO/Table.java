package org.example.DAO;

import org.example.annotation.Coluna;
import org.example.exceptions.PersistException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private String nome;
    private List<Column> colunas;

    public Table(String nome){
        setNome(nome);
        setColunas(new ArrayList<>());
    }

    public List<Column> getColunas() {
        return colunas;
    }

    public void adicionar(Column coluna){
        if(isPresent(coluna)){
            throw new IllegalArgumentException("Nomes de colunas iguais...");
        }
        colunas.add(coluna);
    }

    public boolean isPresent(Column coluna){
        for(Column column : colunas){
            if(coluna.getNome().equals(column.getNome())){
                return true;
            }
        }
        return false;
    }

    public void setColunas(List<Column> colunas) {
        this.colunas = colunas;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
    public String getCreateTable(){
        String createSQL = "CREATE TABLE IF NOT EXISTS " + getNome() + "(id INT AUTO_INCREMENT PRIMARY KEY";
        for(Column coluna : getColunas()){
            createSQL += ", " + coluna.getNome() + " " + coluna.getTipo();
        }

        createSQL += " ); ";

        return createSQL;
    }
    public String getInsertSQLTable(){
        String insertSQL = "INSERT INTO " + getNome() + " (";
        String valoresSQL = ") VALUES (";
        boolean first = true;
        for (Column coluna : colunas) {
            if (!coluna.getNome().equalsIgnoreCase("id")) {
                if (!first) {
                    insertSQL += ", ";
                    valoresSQL += ", ";
                }
                insertSQL += coluna.getNome();
                valoresSQL += "?";
                first = false;
            }
        }
        valoresSQL += ")";
        insertSQL += valoresSQL;
        return insertSQL;
    }

    List<Object> getParametrosByObject(Object obj) {
        List<Object> parametros = new ArrayList<>();
        for (Column coluna : getColunas()) {
            try {
                Field campo = obj.getClass().getDeclaredField(coluna.getNome());
                campo.setAccessible(true);
                parametros.add(campo.get(obj));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new PersistException("Erro ao acessar campo " + coluna.getNome());
            }
        }
        return parametros;
    }
}
