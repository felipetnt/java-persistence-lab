package org.example.model;

public class View {

    public static Aluno updateAluno(){
        Aluno newAluno = new Aluno();
        newAluno.setNome(Leitura.lerString("Insira o nome atualizado: "));
        newAluno.setCpf(Leitura.lerString("Insira o Cpf atualizado: "));
        newAluno.setIdade(Leitura.lerInt("Insira a idade atualizada: "));
        return newAluno;
    }

    public static Aluno lerAluno(){

        Aluno aluno = new Aluno();
        while(true) {
            aluno.setNome(Leitura.lerString("Insira seu nome: "));
            if(aluno.getNome().matches(".*\\d.*")){
                System.out.println("Nao sao permitidos numeros ao inserir, insira de novo mas somente com caracteres...");
            } else {
                break;
            }
        }
        aluno.setCpf(Leitura.lerString("Insira seu CPF abaixo: "));
        while(true){
            String entrada = Leitura.lerString("Insira sua idade: ");
            try{
                int idade = Integer.parseInt(entrada);
                aluno.setIdade(idade);
                break;
            } catch(NumberFormatException e){
                System.out.println("Voce inseriu um caracter ao inves de inserir um numero, favor insira de novo!");
            }
        }
        return aluno;
    }
    public static void menu(){
        boolean loop = true;

        while(loop){
            int option = Leitura.lerInt("Seja bem vindo ao programa de banco da dados que armazena estudantes! SEJA BEM VINDO! \n" +
                    "Voce deseja: \n " +
                    "1 - Cadastrar aluno\n" +
                    "2 - Listar todos os alunos\n" +
                    "3 - Atualizar um aluno pelo ID\n" +
                    "4 - Excluir um aluno pelo ID\n" +
                    "5 - Sair\n ");
            switch (option) {
                case 1:
                    System.out.println("Voce escolheu CADASTRAR ALUNO! ");
                    Command cadastro = new CadastrarAlunoCommand();
                    cadastro.executar();
                    break;
                case 2:
                    System.out.println("Voce escolheu LISTAR todos os alunos de acordo com seu ID: ");
                    Command listar = new ListarTodosCommand();
                    listar.executar();
                    break;
                case 3:
                    System.out.println("Voce escolheu ATUALIZAR um aluno de acordo com sua Primary Key, ou seu ID!");
                    Command update = new AtualizarAlunoCommand();
                    update.executar();
                    break;
                case 4:
                    System.out.println("Voce escolheu EXCLUIR um aluno de acordo com sua Primary Key, ou seu ID! ");
                    Command delete = new ExcluirAlunoCommand();
                    delete.executar();
                    break;
                case 5:
                    System.out.println("Voce escolheu sair do programa! ");
                    loop = false;
                    break;


            }
        }
    }
}
