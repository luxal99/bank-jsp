package app.service.impl;

import app.config.DBConfig;
import app.entity.TypeOfTransaction;
import app.service.dao.TransactionTypeService;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionTypeServiceImpl implements TransactionTypeService {
    @Override
    public List<TypeOfTransaction> getAll() {
        return null;
    }

    @Override
    public TypeOfTransaction findByType(String name) {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createNamedQuery("TypeOfTransaction.findByTitle");
        query.setParameter("title", name);
        return (TypeOfTransaction) query.getSingleResult();
    }
}
