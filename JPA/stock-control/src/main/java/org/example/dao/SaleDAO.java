package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.exception.DataBaseException;
import org.example.domain.model.Sale;

import java.util.List;
import java.util.UUID;

public class SaleDAO implements DAO<Sale> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persistir(Sale entity) {
        try {
            em.persist(entity);
        } catch (Exception e) {
            throw new DataBaseException("Erro ao registrar venda...", e);
        }
    }

    @Override
    public Sale search(UUID id) {
        try {
            return em.find(Sale.class, id);
        } catch (Exception e) {
            throw new DataBaseException("Erro ao buscar venda...", e);
        }
    }

    @Override
    public List<Sale> listAll() {
        try {
            return em.createQuery(
                    "SELECT DISTINCT s FROM Sale s",
                    Sale.class
            ).getResultList();
        } catch (Exception e) {
            throw new DataBaseException("Erro na listagem de vendas...", e);
        }
    }

    @Override
    public void delete(Sale entity) {
        try {
            em.remove(em.contains(entity) ? entity : em.merge(entity));
        } catch (Exception e) {
            throw new DataBaseException("Erro ao deletar venda...", e);
        }
    }
}