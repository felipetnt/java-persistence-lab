package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Review;

import java.util.List;

public class ReviewDAO implements DAO<Review> {
    public void persistir(Review review) {
    EntityManager em = JpaUtil.getInstance().getEntityManager();
    try {
        em.getTransaction().begin();
        em.persist(review);
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
        e.printStackTrace();
    } finally {
        em.close();
    }
}

    @Override
    public Review update(Review entity) {
        return null;
    }

    @Override
    public List<Review> listAll() {
        return List.of();
    }

}
