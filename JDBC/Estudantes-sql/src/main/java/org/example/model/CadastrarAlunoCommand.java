package org.example.model;

import org.example.DAO.AlunoDAO;

import java.sql.*;

public class CadastrarAlunoCommand implements Command {

    @Override
    public void executar() {
        System.out.println("Voce escolheu cadastrar um novo aluno! Por favor insira seus dados!");
        Aluno alunoNovo = View.lerAluno();
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.cadastrar(alunoNovo);
    }
}
