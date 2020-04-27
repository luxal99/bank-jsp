package app.service.impl;

import app.config.DBConfig;
import app.entity.Transaction;
import app.service.dao.TransactionService;
import org.hibernate.Session;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public String save(Transaction transaction) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.Transaction sessionTransaction = session.beginTransaction();
        session.save(transaction);
        sessionTransaction.commit();
        return null;
    }
}
