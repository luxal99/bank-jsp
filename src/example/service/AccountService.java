package example.service;

import example.entity.Account;

import java.util.List;

public interface AccountService {
    public Account save(Account account);
    public  List<Account> getAll();
    public String delete(Integer id);
}
