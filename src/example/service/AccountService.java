package example.service;

import example.entity.Account;

import java.util.List;

public interface AccountService {
    public Account save(Account account);
    public  List<Account> getAll();
    public String delete(Integer id);
    public Account findById(Integer id);
<<<<<<< HEAD
    public String payUp(String accountNuber,Double amount,Account account);
=======
    public List<Account> findAccountByIdClient(Integer id);
>>>>>>> client
}
