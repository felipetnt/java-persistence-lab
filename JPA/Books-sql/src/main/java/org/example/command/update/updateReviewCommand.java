package org.example.command.update;

import org.example.DAO.ReviewDAO;
import org.example.command.Command;
import org.example.models.Review;
import org.example.view.EntityViewer;
import org.example.view.Reader;

import java.util.UUID;

public class updateReviewCommand implements Command {
    public void execute(){
        System.out.println("Voce escolheu atualizar uma resenha!");
        UUID idUpdate = Reader.lerUUID("Insira o Id da resenha: ");
        Review review = EntityViewer.inputReview();
        ReviewDAO DAO = new ReviewDAO();
        DAO.persistir(review);
    }
}
