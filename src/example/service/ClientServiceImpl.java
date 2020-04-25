package example.service;

import example.config.util.DBConfig;
import example.entity.Account;
import example.entity.Client;
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
}