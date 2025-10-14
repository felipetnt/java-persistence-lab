package org.example.command.list;

import org.example.DAO.AuthorDAO;
import org.example.DAO.BookDAO;
import org.example.command.Command;
import org.example.models.Author;
import org.example.models.Book;

import java.util.List;

public class ListAllOfAuthorCommand implements Command {
    @Override
    public void execute() {
        AuthorDAO DAO = new AuthorDAO();
        List<Author> authors = DAO.listAll();

        if (authors.isEmpty()) {
            System.out.println("Nenhum autor cadastrado ainda.");
        } else {
            System.out.println("=== LISTA DE AUTORES ===");
            for (Author a: authors) {
                System.out.println("Título: " + a.getName());
                System.out.println("------------------------");
            }
        }
    }
}
