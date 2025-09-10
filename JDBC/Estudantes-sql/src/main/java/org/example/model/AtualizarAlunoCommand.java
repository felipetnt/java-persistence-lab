package org.example.model;

import org.example.DAO.AlunoDAO;
import org.example.exceptions.AlunoRepetidoException;

import java.sql.*;

public class AtualizarAlunoCommand implements Command {

    @Override
    public void executar() throws AlunoRepetidoException {
        int id = Leitura.lerInt("Voce escolheu atualizar algum aluno da tabela! Por favor insira o id onde voce deseja atualizar o aluno: ");
        Aluno alunoUpdate = View.updateAluno();
        alunoUpdate.setId(id);
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.atualizar(alunoUpdate);
    }
}
