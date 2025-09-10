package org.example.Commands;

import org.example.DAO.AlunoDAO;
import org.example.exceptions.ValidationException;
import org.example.model.Aluno;

import java.util.List;

public class ListarTodosCommand implements Command {
        @Override
        public void executar() {
            AlunoDAO alunoDAO = new AlunoDAO();
            List<Aluno> alunos = alunoDAO.selectAll();

            if (alunos.isEmpty()) {
                throw new ValidationException("Nenhum aluno encontrado... Campo vazio...");
            }

            System.out.println("Lista de Alunos:");
            for (Aluno a : alunos) {
                System.out.println(a);
            }
        }

}
