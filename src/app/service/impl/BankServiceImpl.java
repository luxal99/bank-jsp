package app.service.impl;

import app.entity.Bank;

import javax.transaction.Transactional;

public class BankServiceImpl<Bank> extends CRUDImpl<Bank> {

    public BankServiceImpl(Class<Bank> entityClass) {
        super(entityClass);
    }

    @Transactional
    @Override
    public Bank findById(Integer id) {
        return super.findById(id);
    }
}
