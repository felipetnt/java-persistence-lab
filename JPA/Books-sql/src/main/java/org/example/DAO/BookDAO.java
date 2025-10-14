package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.models.Author;
import org.example.models.Book;

import java.util.List;

public class BookDAO implements DAO<Book>{
    @Override
    public void persistir(Book book) {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Book> findBy(String title){
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        String jpqlString = getJPQLString();
        return em.createQuery(jpqlString, Book.class).setParameter("title", title).getResultList();
    }

    @Override
    public Book update(Book book) {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        Book updatedBook = null;
        try {
            em.getTransaction().begin();
            updatedBook = em.merge(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return updatedBook;
    }

    @Override
    public List<Book> listAll() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        List<Book> books = null;
        try {
            TypedQuery<Book> query = em.createQuery("SELECT DISTINCT b FROM Book b", Book.class);
            books = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return books;
    }

    private String getJPQLString(){
        return "SELECT b FROM Book b WHERE b.title = :title";
    }
}
