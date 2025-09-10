package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Publisher;

public class PublisherDAO implements DAO<Publisher> {
    @Override
    public void persistir(Publisher publisher) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("booksPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(publisher);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
