package org.example.DAO;
import org.example.model.Aluno;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
interface DAO {
    public void cadastrar(Aluno aluno);
    public void atualizar(Aluno aluno);
    public void excluir(int id);
    public void listarTodos();
    public ArrayList<Aluno> pesquisarByNome(String nome);
    public ArrayList<Aluno> pesquisarByCpf(String cpf);
}
