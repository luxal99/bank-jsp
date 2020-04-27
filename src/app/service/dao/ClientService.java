package app.service.dao;

import app.entity.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);
    List<Client> getAll();
    Client findClientById(Integer id);
    String updateClient(Client client);

}
