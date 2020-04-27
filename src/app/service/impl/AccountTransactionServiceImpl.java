package app.service.impl;

import app.config.DBConfig;
import app.entity.AccountTransaction;
import app.service.dao.AccountTransactionService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountTransactionServiceImpl implements AccountTransactionService {


    @Override
    public String save(AccountTransaction accountTransaction) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(accountTransaction);
        transaction.commit();
        return "Saved";
    }

    @Override
    public List<AccountTransaction> getAll() {
        return null;
    }
}
