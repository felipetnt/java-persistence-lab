package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.domain.model.Product;

import java.util.List;
import java.util.UUID;

public class ProductDAO implements DAO<Product> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persistir(Product entity) {
        em.persist(entity);
    }

    @Override
    public Product search(UUID id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> listAll() {
        return em.createQuery(
                "SELECT DISTINCT p FROM Product p",
                Product.class
        ).getResultList();
    }

    @Override
    public void delete(Product entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}