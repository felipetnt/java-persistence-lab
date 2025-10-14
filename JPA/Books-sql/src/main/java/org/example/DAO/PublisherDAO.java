package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Book;
import org.example.models.Publisher;

import java.util.List;

public class PublisherDAO implements DAO<Publisher> {
    @Override
    public void persistir(Publisher publisher) {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(publisher);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Publisher update(Publisher entity) {
        return null;
    }

    @Override
    public List<Publisher> listAll() {
        return List.of();
    }

    public List<Publisher> findBy(String name){
        EntityManager em = JpaUtil.getInstance().getEntityManager();

        String jpqlString = getJPQLString();
        return em.createQuery(jpqlString, Publisher.class).setParameter("name", name).getResultList();
    }

    public static Publisher ensurePublisherExists(String name) {
        PublisherDAO publisherDAO = new PublisherDAO();
        List<Publisher> publishers = publisherDAO.findBy(name);
        if (!publishers.isEmpty()) {
            System.out.println("Editora já existente encontrada: " + name);
            return publishers.get(0);
        } else {
            Publisher pub = new Publisher(name);
            publisherDAO.persistir(pub);
            System.out.println("Nova editora criada: " + name);
            return pub;
        }
    }

    private String getJPQLString(){
        return "SELECT p FROM Publisher p WHERE p.name = :name";
    }
}
