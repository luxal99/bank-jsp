package app.service.dao;

import app.entity.TypeOfTransaction;

import java.util.List;

public interface TransactionTypeService {
    List<TypeOfTransaction> getAll();
    TypeOfTransaction findByType(String name);
}
