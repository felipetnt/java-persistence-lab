package org.example.command.update;

import org.example.DAO.BookDAO;
import org.example.command.Command;
import org.example.models.Book;
import org.example.view.EntityViewer;
import org.example.view.Reader;

import java.util.UUID;

public class updateBookCommand implements Command {
    public void execute(){
        System.out.println("Voce escolheu atualizar um livro!");
        UUID idUpdate = Reader.lerUUID("Insira o Id do livro: ");
        Book book = EntityViewer.inputBook();
        BookDAO DAO = new BookDAO();
        DAO.persistir(book);
    }
}
