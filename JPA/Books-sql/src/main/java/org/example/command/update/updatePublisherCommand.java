package org.example.command.update;

import org.example.DAO.DAO;
import org.example.DAO.PublisherDAO;
import org.example.command.Command;
import org.example.models.Publisher;
import org.example.view.EntityViewer;
import org.example.view.Reader;

import java.util.UUID;

public class updatePublisherCommand implements Command {
    public void execute(){
        System.out.println("Voce escolheu atualizar uma editora!");
        UUID idUpdate = Reader.lerUUID("Insira o Id da editora: ");
        Publisher publisher = EntityViewer.inputPublisher();
        PublisherDAO DAO = new PublisherDAO();
        DAO.persistir(publisher);
    }
}
