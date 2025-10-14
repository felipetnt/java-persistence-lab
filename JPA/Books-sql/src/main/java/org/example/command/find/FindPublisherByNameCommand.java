package org.example.command.find;

import org.example.DAO.AuthorDAO;
import org.example.DAO.PublisherDAO;
import org.example.command.Command;
import org.example.models.Author;
import org.example.models.Publisher;
import org.example.view.Printer;
import org.example.view.Reader;

import java.util.List;

public class FindPublisherByNameCommand implements Command {
    @Override
    public void execute() {
        String findName = Reader.lerString("Voce escolheu buscar uma editora pelo seu nome, digite o nome que deseja: ");
        PublisherDAO DAO = new PublisherDAO();
        List<Publisher> publishersByName = DAO.findBy(findName);
        Printer.printList(publishersByName);
    }
}
