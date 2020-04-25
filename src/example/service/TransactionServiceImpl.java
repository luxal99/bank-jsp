package example.service;

import example.config.util.DBConfig;
import example.entity.Transaction;
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
