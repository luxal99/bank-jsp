package app.service.dao;

import app.entity.AccountTransaction;

import java.util.List;

public interface AccountTransactionService {
    String save(AccountTransaction accountTransaction);
    List<AccountTransaction> getAll();
}
