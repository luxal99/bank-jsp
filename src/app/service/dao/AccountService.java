package app.service.dao;

import app.entity.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);

    List<Account> getAll();

    String delete(Integer id);

    Account findById(Integer id);

    String transfer(String accountNuber, Double amount, Account senderAccount, Account reciverAccount) ;

    List<Account> findAccountByIdClient(Integer id);

    Account findByAccountNumber(String accountNumber);
}