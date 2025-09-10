package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Review;

public class ReviewDAO implements DAO<Review> {
    public void persistir(Review review){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("booksPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(review);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
