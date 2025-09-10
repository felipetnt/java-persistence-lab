package org.example.view;

import org.example.Commands.PersistirCommand;
import org.example.Commands.Command;
import org.example.Validator.Validator;
import org.example.model.*;
import org.example.Commands.ListarTodosCommand;

public class View {
    public static Aluno lerAluno(){

        Aluno aluno = new Aluno();
        // Colocar a validacao dentro de leitor, sobrecarregando o metodo com Regex.
        while(true) {
            aluno.setNome(Leitor.lerString("Insira seu nome: "));
            if(aluno.getNome().matches(".*\\d.*")){
                System.out.println("Nao sao permitidos numeros ao inserir, insira de novo mas somente com caracteres...");
            } else {
                break;
            }
        }
        // Arrumar a cagada que voce fez aqui...
        aluno.setCpf(Leitor.lerString("Insira seu CPF abaixo: "));
        while(true){
            String entrada = Leitor.lerString("Insira sua primeira nota na prova: ");
            try{
                int notaUm = Integer.parseInt(entrada);
                aluno.setNotaUm(notaUm);
                break;
            } catch(NumberFormatException e){
                System.out.println("Voce inseriu um caracter ao inves de inserir um numero, favor insira de novo!");
            }
        }

        while(true){
            String entrada = Leitor.lerString("Insira sua segunda nota na prova: ");
            try{
                int notaDois = Integer.parseInt(entrada);
                aluno.setNotaDois(notaDois);
                break;
            } catch(NumberFormatException e){
                System.out.println("Voce inseriu um caracter ao inves de inserir um numero, favor insira de novo!");
            }
        }

        Validator.validateEntity(aluno);

        return aluno;
    }
    public static void menu(){
        boolean loop = true;

        while(loop){
            int option = Leitor.lerInt("Seja bem vindo ao programa de banco da dados que armazena estudantes! SEJA BEM VINDO! \n" +
                    "Voce deseja: \n " +
                    "1 - Cadastrar aluno\n" +
                    "2 - Listar todos os alunos\n" +
                    "3 - Sair\n ");

            switch (option) {
                case 1:
                    System.out.println("Voce escolheu cadastrar um aluno! ");
                    Command cadastrar = new PersistirCommand();
                    cadastrar.executar();
                    break;
                case 2:
                    System.out.println("Voce escolheu listar todos os alunos!");
                    Command listar = new ListarTodosCommand();
                    listar.executar();
                    break;
                case 3:
                    System.out.println("Voce escolheu sair do programa! ");
                    loop = false;
                    break;
            }
        }
    }
}
