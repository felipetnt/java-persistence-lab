package org.example.command.insert;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.DAO.BookDAO;
import org.example.command.Command;
import org.example.models.Author;
import org.example.models.Book;
import org.example.view.EntityViewer;

public class InsertBookCommand implements Command {
    public void execute(){
        System.out.println("Voce escolheu inserir um Livro!");
        Book book = EntityViewer.inputBook();
        BookDAO DAO = new BookDAO();
        DAO.persistir(book);
    }
}
