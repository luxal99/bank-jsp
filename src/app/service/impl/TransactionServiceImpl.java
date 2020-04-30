package app.service.impl;

import app.entity.Transaction;

import javax.transaction.Transactional;
import java.util.List;

public class TransactionServiceImpl extends CRUDImpl<Transaction> {

    @Override
    public Object save(Object entity) {
        return super.save(entity);
    }

    @Transactional
    @Override
    public List<Transaction> getAll(Class entityClass) {
        return super.getAll(entityClass);
    }
}
