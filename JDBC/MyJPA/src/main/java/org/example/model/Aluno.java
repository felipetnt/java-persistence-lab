package org.example.model;

import org.example.annotation.Coluna;
import org.example.annotation.NotEmpty;
import org.example.annotation.NotNull;
import org.example.annotation.Tabela;


@Tabela(name = "aluno")
public class Aluno {
    @NotNull(message = "Este campo eh obrigatorio...")
    @NotEmpty(message = "Este campo eh obrigatorio...")
    private int id;

    @NotNull(message = "Este campo eh obrigatorio...")
    @NotEmpty(message = "Este campo eh obrigatorio...")
    @Coluna(name = "nome"   )
    private String nome;

    @NotNull(message = "Este campo eh obrigatorio...")
    @NotEmpty(message = "Este campo eh obrigatorio...")
    @Coluna(name = "cpf")
    private String cpf;

    @NotNull(message = "Este campo eh obrigatorio...")
    @NotEmpty(message = "Este campo eh obrigatorio...")
    @Coluna(name = "notaUm")
    private double notaUm;

    @NotNull(message = "Este campo eh obrigatorio...")
    @NotEmpty(message = "Este campo eh obrigatorio...")
    @Coluna(name = "notaDois")
    private double notaDois;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getNotaUm() {
        return notaUm;
    }

    public void setNotaUm(double notaUm) {
        this.notaUm = notaUm;
    }

    public double getNotaDois() {
        return notaDois;
    }

    public void setNotaDois(double notaDois) {
        this.notaDois = notaDois;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                " | Nome: " + getNome() +
                " | CPF: " + getCpf() +
                " | Nota 1: " + getNotaUm() +
                " | Nota 2: " + getNotaDois();

    }
}
