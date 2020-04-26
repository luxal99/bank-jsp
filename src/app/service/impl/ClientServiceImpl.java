package app.service.impl;

import app.config.DBConfig;
import app.entity.Client;
import app.service.dao.ClientService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public Client save(Client client) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();

        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clientList = new ArrayList<>();
        Session session = DBConfig.getSessionFactory().openSession();

        Query query = session.createNamedQuery("Client.findAll");
        clientList = query.getResultList();
        return clientList;
    }

    @Override
    public Client findClientById(Integer id) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createNamedQuery("Client.findByIdClient");
        query.setInteger("idClient", id);
        Client client = (Client) query.getResultList().get(0);
        return client;
    }

    @Override
    public String updateClient(Client client) {

        Session session = DBConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();

        return "Updated";
    }
}