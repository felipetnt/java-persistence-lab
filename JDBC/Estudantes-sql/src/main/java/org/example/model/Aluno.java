package org.example.model;

public class Aluno {
    private String nome;
    private String cpf;
    private int idade;
    private int id;

    public Aluno(int id, String nome, String cpf, int idade){
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
    }
    public Aluno(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
