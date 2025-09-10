package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Author;
import org.example.view.EntityViewer;

public class AuthorDAO implements DAO<Author> {

    @Override
    public void persistir(Author author){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("booksPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(author);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
