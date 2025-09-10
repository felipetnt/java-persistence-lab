package org.example.model;

import org.example.DAO.AlunoDAO;

import java.sql.*;
import java.util.List;
public class ListarTodosCommand implements Command {

    @Override
    public void executar() {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.listarTodos();
//        List<Aluno> todos = alunoDAO.listarTodos();
//        for (Aluno a : todos) {
//            System.out.println(a);
//        }
    }
}
