package org.example.model;

import org.example.DAO.AlunoDAO;

import java.sql.*;

public class ExcluirAlunoCommand implements Command {
    @Override
    public void executar() {
        int id = Leitura.lerInt("Voce escolheu excluir algum aluno da tabela! Por favor insira o id onde voce deseja excluir o aluno: ");
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.excluir(id);
    }
}
