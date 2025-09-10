package org.example.DAO;

import java.sql.*;

import org.example.exceptions.AlunoRepetidoException;
import org.example.exceptions.DAOException;
import org.example.model.Aluno;

import java.util.ArrayList;

public class AlunoDAO implements DAO{

    @Override
    public void atualizar (Aluno aluno) {
        try (Connection conn = FactoryConnection.getConnection()){
            ArrayList<Aluno> temporario = pesquisarByCpf(aluno.getCpf());
            if (temporario != null) {
                throw new AlunoRepetidoException();
            }
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                String sql = "UPDATE aluno SET nome = ?, cpf = ?, idade = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, aluno.getNome());
                ps.setString(2, aluno.getCpf());
                ps.setInt(3, aluno.getIdade());
                ps.setInt(4, aluno.getId());

                int linhasAfetadas = ps.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Aluno com ID " + aluno.getId() + " atualizado com sucesso!");
                } else {
                    System.out.println("Nenhum aluno encontrado com o ID " + aluno.getId() + ".");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao conectar no banco: " + e.getMessage());
        }
    }

    @Override
    public void cadastrar(Aluno aluno){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = FactoryConnection.getConnection()){
                ArrayList<Aluno> temporario = pesquisarByCpf(aluno.getCpf());
                if(conn == null){
                    throw new DAOException();
                }
                if (temporario != null) {
                    throw new AlunoRepetidoException();
                }
                System.out.println("Conexão estabelecida com sucesso!");
                String sql = "INSERT INTO aluno (nome, cpf, idade) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, aluno.getNome());
                ps.setString(2, aluno.getCpf());
                ps.setInt(3, aluno.getIdade());

                int linhasAfetadas = ps.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Aluno cadastrado com sucesso!");
                } else {
                    System.out.println("Nenhum aluno foi cadastrado.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar no banco: " + e.getMessage());
        } catch  (DAOException e ){
            e.printStackTrace();
            System.out.println("Ops... Algo deu errado... Contate a administracao...");
        } catch (AlunoRepetidoException e){
            e.printStackTrace();
            System.out.println("Ops... Aluno ja cadastrado no sistema...");
        }
    }
    @Override
    public void excluir(int idDelete) {
        try (Connection conn = FactoryConnection.getConnection()) {
            if (conn != null) {

                String sql = "DELETE FROM aluno WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idDelete);

                int linhasAfetadas = ps.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Aluno com ID " + idDelete + " deletado com sucesso!");
                } else {
                    System.out.println("Nenhum aluno encontrado com o ID " + idDelete + ".");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao conectar no banco: " + e.getMessage());
        } catch (DAOException e){
            e.printStackTrace();
            System.out.println("Atencao algo deu errado... Contate a administracao...");
        }
    }
    @Override
    public void listarTodos(){
        try (Connection conn = FactoryConnection.getConnection()) {
            System.out.println("Conexão estabelecida com sucesso!");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM aluno");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                int idade = rs.getInt("idade");
                System.out.println("Nome: " + nome + ", CPF: " + cpf + ", Idade: " + idade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao conectar no banco: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Aluno> pesquisarByNome(String nome) {
        ArrayList<Aluno> encontrados = new ArrayList<>();
        String sql = "SELECT * FROM aluno WHERE nome = ?";

        try (Connection conn = FactoryConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                int idade = rs.getInt("idade");

                Aluno aluno = new Aluno(id, nome, cpf, idade);
                encontrados.add(aluno);
            }

            if (encontrados.isEmpty()) {
                return null;
            }

            return encontrados;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException();
        }
    }

    @Override
    public ArrayList<Aluno> pesquisarByCpf(String cpf) {
        ArrayList<Aluno> encontrados = new ArrayList<>();
        String sql = "SELECT * FROM aluno WHERE cpf = ?";

        try (Connection conn = FactoryConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");

                Aluno aluno = new Aluno(id, nome, cpf, idade);
                encontrados.add(aluno);
            }

            if (encontrados.isEmpty()) {
                return null;
            }

            return encontrados;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException();
        }
    }

    public ArrayList<Aluno> pesquisarByCpf(Connection conn, String cpf) throws SQLException {
        ArrayList<Aluno> encontrados = new ArrayList<>();
        String sql = "SELECT * FROM aluno WHERE cpf = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                encontrados.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        cpf,
                        rs.getInt("idade")
                ));
            }
            return encontrados.isEmpty() ? null : encontrados;
        }
    }

}
