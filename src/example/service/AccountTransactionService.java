package example.service;

import example.entity.AccountTransaction;

import java.util.List;

public interface AccountTransactionService {
    public String save(AccountTransaction accountTransaction);
    public List<AccountTransaction> getAll();
}
