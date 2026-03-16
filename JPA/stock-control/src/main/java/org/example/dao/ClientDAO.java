package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.exception.DataBaseException;
import org.example.domain.model.Client;

import java.util.List;
import java.util.UUID;

public class ClientDAO implements DAO<Client> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persistir(Client entity) {
        try {
            em.persist(entity);
        } catch (Exception e) {
            throw new DataBaseException("Erro ao cadastrar cliente...", e);
        }
    }

    @Override
    public Client search(UUID id) {
        try {
            return em.find(Client.class, id);
        } catch (Exception e) {
            throw new DataBaseException("Erro ao buscar cliente...", e);
        }
    }

    @Override
    public List<Client> listAll() {
        try {
            return em.createQuery(
                    "SELECT DISTINCT c FROM Client c",
                    Client.class
            ).getResultList();
        } catch (Exception e) {
            throw new DataBaseException("Erro na listagem de clientes...", e);
        }
    }

    @Override
    public void delete(Client entity) {
        try {
            em.remove(em.contains(entity) ? entity : em.merge(entity));
        } catch (Exception e) {
            throw new DataBaseException("Erro ao deletar cliente...", e);
        }
    }
}