package org.example.command.update;

import org.example.DAO.AuthorDAO;
import org.example.command.Command;
import org.example.models.Author;
import org.example.view.EntityViewer;
import org.example.view.Reader;

import java.util.UUID;

public class updateAuthorCommand implements Command {
    public void execute(){
        System.out.println("Voce escolheu atualizar um autor!");
        UUID idUpdate = Reader.lerUUID("Insira o Id do autor: ");
        Author author = EntityViewer.inputAuthor();
        AuthorDAO DAO = new AuthorDAO();
        DAO.persistir(author);
    }
}
