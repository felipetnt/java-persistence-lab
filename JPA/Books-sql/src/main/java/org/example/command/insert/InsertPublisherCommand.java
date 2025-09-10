package org.example.command.insert;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.DAO.PublisherDAO;
import org.example.command.Command;
import org.example.models.Book;
import org.example.models.Publisher;
import org.example.view.EntityViewer;

public class InsertPublisherCommand implements Command {
    public void execute(){
        System.out.println("Voce escolheu inserir uma Editora!");
        Publisher publisher = EntityViewer.inputPublisher();
        PublisherDAO DAO = new PublisherDAO();
        DAO.persistir(publisher);

    }
}
