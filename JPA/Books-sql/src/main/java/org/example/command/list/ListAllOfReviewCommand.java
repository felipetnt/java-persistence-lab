package org.example.command.list;

import org.example.DAO.PublisherDAO;
import org.example.command.Command;
import org.example.models.Publisher;

import java.util.List;

public class ListAllOfReviewCommand implements Command {
    @Override
    public void execute() {
        PublisherDAO DAO = new PublisherDAO();
        List<Publisher> publishers = DAO.listAll();

        if (publishers.isEmpty()) {
            System.out.println("Nenhuma editora cadastrada ainda.");
        } else {
            System.out.println("=== LISTA DE RESENHAS ===");
            for (Publisher p: publishers) {
                System.out.println("Nome: " + p.getName());
                System.out.println("------------------------");
            }
        }
    }
}
