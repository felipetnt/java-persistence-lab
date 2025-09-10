package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Book;

public class BookDAO implements DAO<Book>{
    @Override
    public void persistir(Book book) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("booksPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(book);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
