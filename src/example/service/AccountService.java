package example.service;

import example.entity.Account;

import java.util.List;

public interface AccountService {
    public Account save(Account account);

    public List<Account> getAll();

    public String delete(Integer id);

    public Account findById(Integer id);

    public String transfer(String accountNuber, Double amount, Account senderAccount,Account reciverAccount);

    public List<Account> findAccountByIdClient(Integer id);

    public Account findByAccountNumber(String accountNumber);
}