package org.example.Commands;

import org.example.DAO.AlunoDAO;
import org.example.model.Aluno;
import org.example.view.View;

public class PersistirCommand implements Command {
    @Override
    public void executar() {
        Aluno alunoNovo = View.lerAluno();
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.persistir(alunoNovo);
    }
}
