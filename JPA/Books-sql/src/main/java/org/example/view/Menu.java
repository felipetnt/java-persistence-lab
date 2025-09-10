package org.example.view;

import org.example.command.Command;
import org.example.command.find.FindAuthorByTitleCommand;
import org.example.command.find.FindBookByNameCommand;
import org.example.command.find.FindPublisherByNameCommand;
import org.example.command.insert.InsertAuthorCommand;
import org.example.command.insert.InsertBookCommand;
import org.example.command.insert.InsertPublisherCommand;
import org.example.command.insert.InsertReviewCommand;
import org.example.command.update.updateAuthorCommand;
import org.example.command.update.updateBookCommand;
import org.example.command.update.updatePublisherCommand;
import org.example.command.update.updateReviewCommand;

public class Menu {
    public static void show(){
        boolean loop = true;
        while(loop){
            int option = Reader.lerInt(
                    "-----------------------------\n" +
                            "        MENU PRINCIPAL       \n" +
                            "-----------------------------\n" +
                            "1 - Cadastrar\n" +
                            "2 - Atualizar\n" +
                            "3 - Buscar\n" +
                            "4 - Sair\n" +
                            "-----------------------------\n" +
                            "Escolha uma opção: "
            );

            switch (option) {
                case 1:
                    Menu.insertOption();
                    break;
                case 2:
                    Menu.updateOption();
                    break;
                case 3:
                    Menu.findOption();
                    break;
                case 4:
                    loop = false;
                    break;
            }
        }
    }

    public static void insertOption(){
        int optionInsert = Reader.lerInt(
                "-----------------------------\n" +
                        "         CADASTRAR           \n" +
                        "-----------------------------\n" +
                        "1 - Livro\n" +
                        "2 - Editora\n" +
                        "3 - Resenha\n" +
                        "4 - Autor(a)\n" +
                        "-----------------------------\n" +
                        "Escolha uma opção: ");
        switch (optionInsert){
            case 1:
                Command insertBook = new InsertBookCommand();
                insertBook.execute();
                break;
            case 2:
                Command insertPublisher = new InsertPublisherCommand();
                insertPublisher.execute();
                break;
            case 3:
                Command insertReview = new InsertReviewCommand();
                insertReview.execute();
                break;
            case 4:
                Command insertAuthor = new InsertAuthorCommand();
                insertAuthor.execute();
                break;
        }
    }

    public static void updateOption(){
        int optionUpdate = Reader.lerInt(
                   "-----------------------------\n" +
                        "          ATUALIZAR          \n" +
                        "-----------------------------\n" +
                        "1 - Livro\n" +
                        "2 - Editora\n" +
                        "3 - Resenha\n" +
                        "4 - Autor(a)\n" +
                        "-----------------------------\n" +
                        "Escolha uma opção: "
        );
        switch (optionUpdate){
            case 1:
                Command updateBook = new updateBookCommand();
                updateBook.execute();
                break;
            case 2:
                Command updatePublisher = new updatePublisherCommand();
                updatePublisher.execute();
                break;
            case 3:
                Command updateReview = new updateReviewCommand();
                updateReview.execute();
                break;
            case 4:
                Command updateAuthor = new updateAuthorCommand();
                updateAuthor.execute();
                break;
        }
    }

    public static void findOption(){
        int optionFind = Reader.lerInt(
                "-----------------------------\n" +
                        "           BUSCAR            \n" +
                        "-----------------------------\n" +
                        "1 - Livro pelo titulo\n" +
                        "2 - Editora pelo nome\n" +
                        "3 - Autor(a) pelo nome\n" +
                        "-----------------------------\n" +
                        "Escolha uma opção: "
        );
        switch (optionFind){
            case 1:
                Command findBookByTitle = new FindBookByNameCommand();
                findBookByTitle.execute();
                break;
            case 2:
                Command findPublisherByName = new FindPublisherByNameCommand();
                findPublisherByName.execute();
                break;
            case 3:
                Command findAuthorByName = new FindAuthorByTitleCommand();
                findAuthorByName.execute();
                break;
        }
    }
}
