package org.example.service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dao.ClientDAO;
import org.example.exception.ClientNotFoundException;
import org.example.domain.model.Client;

import java.util.List;
import java.util.UUID;

public class ClientService {

    @Inject
    private ClientDAO clientDAO;

    @Transactional
    public void create(Client client) {
        clientDAO.persistir(client);
    }

    public Client findById(UUID id) {
        Client client = clientDAO.search(id);

        if (client == null) {
            throw new ClientNotFoundException("Cliente não encontrado");
        }

        return client;
    }

    public List<Client> listAll() {
        return clientDAO.listAll();
    }

    @Transactional
    public void update(UUID id, Client updatedData) {

        Client client = findById(id);

        client.setName(updatedData.getName());
        client.setEmail(updatedData.getEmail());
    }

    @Transactional
    public void delete(UUID id) {

        Client client = findById(id);

        clientDAO.delete(client);
    }
}
