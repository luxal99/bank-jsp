package app.service.impl;

import app.entity.AccountTransaction;

public class AccountTransactionServiceImpl<AccountTransaction> extends CRUDImpl<AccountTransaction> {


    public AccountTransactionServiceImpl(Class<AccountTransaction> entityClass) {
        super(entityClass);
    }

    @Override
    public AccountTransaction save(AccountTransaction entity) {
        return super.save(entity);
    }
}
