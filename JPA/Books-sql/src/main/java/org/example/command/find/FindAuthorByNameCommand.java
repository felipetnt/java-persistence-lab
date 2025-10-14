package org.example.command.find;

import org.example.DAO.AuthorDAO;
import org.example.command.Command;
import org.example.models.Author;
import org.example.view.Printer;
import org.example.view.Reader;

import java.util.List;

public class FindAuthorByNameCommand implements Command {
    @Override
    public void execute(){
        String findName = Reader.lerString("Voce escolheu buscar um autor pelo seu nome, digite o nome que deseja: ");
        AuthorDAO DAO = new AuthorDAO();
        List<Author> authorsByName = DAO.findBy(findName);
        Printer.printList(authorsByName);
    }
}
