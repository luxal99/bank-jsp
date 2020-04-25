package example.service;

import example.entity.Client;

import java.util.List;

public interface ClientService {
    public Client save(Client client);
    public List<Client> getAll();
    public Client findClientById(Integer id);
    public String updateClient(Client client);

}
