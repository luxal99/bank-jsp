package example.service;

import example.entity.TypeOfTransaction;

import java.util.List;

public interface TransactionTypeService {
    public List<TypeOfTransaction> getAll();
    public TypeOfTransaction findByType(String name);
}
