package app.service.impl;

import app.entity.Transaction;

import javax.transaction.Transactional;
import java.util.List;

public class TransactionServiceImpl<Transaction> extends CRUDImpl<Transaction> {

    @Override
    public Object save(Object entity) {
        return super.save(entity);
    }

    public TransactionServiceImpl(Class<Transaction> entityClass) {
        super(entityClass);
    }



    @Override
    public List<Transaction> getAll() {
        return super.getAll();
    }
}
