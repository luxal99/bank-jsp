package app.service.impl;

import app.config.DBConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionTypeServiceImpl<TypeOfTransaction> extends CRUDImpl<TypeOfTransaction> {
    public TransactionTypeServiceImpl(Class<TypeOfTransaction> entityClass) {
        super(entityClass);
    }

    @Override
    public List<TypeOfTransaction> getAll() {
        return super.getAll();
    }

    public TypeOfTransaction findByType(String name) {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createNamedQuery("TypeOfTransaction.findByTitle");
        query.setParameter("title", name);
        return (TypeOfTransaction) query.getSingleResult();
    }
}
