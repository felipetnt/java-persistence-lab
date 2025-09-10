package org.example.command.insert;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.DAO.AuthorDAO;
import org.example.command.Command;
import org.example.models.Author;
import org.example.view.EntityViewer;
import org.example.view.Menu;

public class InsertAuthorCommand implements Command {
    public void execute(){
        System.out.println("Voce escolheu inserir um autor!");
        Author author = EntityViewer.inputAuthor();
        AuthorDAO DAO = new AuthorDAO();
        DAO.persistir(author);
    }
}
