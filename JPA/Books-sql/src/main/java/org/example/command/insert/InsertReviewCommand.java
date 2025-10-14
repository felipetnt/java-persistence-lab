package org.example.command.insert;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.DAO.ReviewDAO;
import org.example.command.Command;
import org.example.models.Book;
import org.example.models.Review;
import org.example.view.EntityViewer;

public class InsertReviewCommand implements Command {
    public void execute(){
        System.out.println("Voce escolheu inserir uma Resenha!");
        Review review = EntityViewer.inputReview();
        ReviewDAO DAO = new ReviewDAO();
        DAO.persistir(review);
        System.out.println("Resenha persistida com sucesso.");
    }
}
