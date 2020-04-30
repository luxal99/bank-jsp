package app.service.impl;
import app.entity.Bank;

public class BankServiceImpl<Bank> extends CRUDImpl<Bank> {

    public BankServiceImpl(Class<Bank> entityClass) {
        super(entityClass);
    }

    @Override
    public Bank findById(Class<Bank> entityClass, Integer id) {
        return super.findById(entityClass, id);
    }
}
