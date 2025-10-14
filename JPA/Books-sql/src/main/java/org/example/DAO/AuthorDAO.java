package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.models.Author;
import org.example.models.Book;
import org.example.models.Publisher;

import java.util.List;

public class AuthorDAO implements DAO<Author> {

    @Override
    public void persistir(Author author) {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Author update(Author entity) {
        return null;
    }

    @Override
    public List<Author> listAll() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        List<Author> authors = null;
        try {
            TypedQuery<Author> query = em.createQuery("SELECT DISTINCT a FROM Author a", Author.class);
            authors = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return authors;
    }
    
    public List<Author> findBy(String name){
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        String jpqlString = getJPQLString();
        return em.createQuery(jpqlString, Author.class).setParameter("name", name).getResultList();
    }

    public static Author ensureAuthorExists(String name) {
        AuthorDAO authorDAO = new AuthorDAO();
        List<Author> existingAuthors = authorDAO.findBy(name);

        Author author;
        if (!existingAuthors.isEmpty()) {
            author = existingAuthors.get(0);
            System.out.println("Autor já existente encontrado: " + author.getName());
        } else {
            author = new Author(name);
            authorDAO.persistir(author);
            System.out.println("Novo autor criado: " + author.getName());
        }

        return author;
    }

    private String getJPQLString(){
        return "SELECT a FROM Author a WHERE a.name = :name";
    }
}
