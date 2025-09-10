package org.example.DAO;

import org.example.model.Aluno;
import java.util.List;

public class AlunoDAO implements DAO<Aluno>{

    @Override
    public void persistir(Aluno aluno) {
        JPAManager jpa = JPAManager.getInstance(); // Delega para a JPAManager.
        jpa.persistir(aluno);
    }

    @Override
    public List<Aluno> selectAll(){
        JPAManager jpa = JPAManager.getInstance();
        return jpa.buscarTodos(Aluno.class);
    }
}
