package org.example.DAO;

import org.example.annotation.Coluna;
import org.example.annotation.Tabela;
import org.example.exceptions.*;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


class JPAManager implements JPA{
    private static JPAManager instance;

    private JPAManager(){

    }

    public static JPAManager getInstance() {
        if(instance == null){
            instance = new JPAManager();
        }
        return instance;
    }

    public void persistir(Object obj) throws PersistException {
        Class<?> clazz = obj.getClass();
        Field[] campos = clazz.getDeclaredFields();
        if(!clazz.isAnnotationPresent(Tabela.class)){
            throw new TableNotFoundException("A classe nao possui o @Tabela");
        }
        Table table = new Table(clazz.getAnnotation(Tabela.class).name());
        for (Field campo : campos) {
            if (campo.isAnnotationPresent(Coluna.class)) {
                Coluna coluna = campo.getAnnotation(Coluna.class);
                Column column = new Column(coluna.name(), getType(campo));
                table.adicionar(column);
            }
        }

        createTable(table);
        insert(table, obj);
    }

    private void createTable(Table tabela){

        String createSQL = tabela.getCreateTable();

        try (Connection conn = FactoryConnection.getConnection()) {
            if (conn == null) {
                throw new DAOException("Erro na conexão! Por favor chame um administrador");
            }
            PreparedStatement ps = conn.prepareStatement(createSQL);
            ps.executeUpdate();
            System.out.println("Tabela criada/aprovada | " + tabela.getNome());
        } catch(SQLException e){
            e.printStackTrace();
            throw new DAOException("Erro com a conexao... Chame um administrador...");
        }
    }

    private void insert(Table tabela, Object obj){
        List<Object> parametros = tabela.getParametrosByObject(obj);
        String insertSQL = tabela.getInsertSQLTable();

        try (Connection conn = FactoryConnection.getConnection()) {
            if (conn == null) {
                throw new DAOException("Erro na conexão! Por favor chame um administrador");
            }

            PreparedStatement ps = conn.prepareStatement(insertSQL);
            for (int i = 0; i < parametros.size(); i++) {
                ps.setObject(i + 1, parametros.get(i));
            }

            ps.executeUpdate();
            System.out.println("Objeto inserido com sucesso!!!!");

        } catch (SQLException e) {
            throw new PersistException("Erro ao inserir no banco: " + e.getMessage());
        }
    }
    public <T> List<T> buscarTodos(Class<T> clazz) {
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new PersistException("A classe não possui @Tabela");
        }

        String tableName = clazz.getAnnotation(Tabela.class).name();
        List<T> resultados = new ArrayList<>();

        String sql = "SELECT * FROM " + tableName;

        try (Connection conn = FactoryConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            Field[] campos = clazz.getDeclaredFields();

            while (rs.next()) {
                T obj = clazz.getDeclaredConstructor().newInstance();

                for (Field campo : campos) {
                    if (campo.isAnnotationPresent(Coluna.class)) {
                        campo.setAccessible(true);
                        Coluna coluna = campo.getAnnotation(Coluna.class);
                        Object valor = rs.getObject(coluna.name());

                        campo.set(obj, valor);
                    }
                }
                resultados.add(obj);
            }

        } catch (SQLException e) {
            throw new PersistException("Erro ao buscar dados: " + e.getMessage());
        } catch (ReflectiveOperationException e) {
            throw new InstanceCreationException("Erro ao criar instância da classe: " + e.getMessage());
        }

        return resultados;
    }

    public String getType(Field campo){
        Class<?> tipo = campo.getType();
        String text;
        if(tipo.equals(String.class)){
            text = "VARCHAR(250)";
        } else {
            if(tipo.equals(int.class)){
                text = "INT";
            } else {
                if(tipo.equals(double.class)){
                    text = "DOUBLE";
                } else {
                    if(tipo.equals(Date.class)){
                        text = "DATE";
                    } else {
                        if(tipo.equals(Calendar.class)){
                            text = "DATE";
                        } else {
                            throw new TypeNotFoundException("Tipo de instancia nao encontrado... Chame um administrador...");
                        }
                    }
                }
            }
        }
        return text;
    }
}
