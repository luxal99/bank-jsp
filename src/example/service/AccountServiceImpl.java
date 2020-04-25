package example.service;

import example.config.util.DBConfig;
import example.entity.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {


    @Override
    public Account save(Account account) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        return account;
    }

    @Override
    public List<Account> getAll() {
        List<Account> employeeList = new ArrayList();
        Session session = DBConfig.getSessionFactory().openSession();

        Query query = session.createNamedQuery("Account.findAll");
        employeeList = query.getResultList();

        return employeeList;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }

    @Override
    public Account findById(Integer id) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createNamedQuery("Account.findByIdAccount");
        query.setInteger("idAccount", id);
        Account account = (Account) query.getResultList().get(0);
        return account;
    }

    @Override
    public String payUp(String accountNumber, Double amount) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        org.hibernate.query.Query query = session.createQuery("update Account set balance = balance+ :amount where accountNumber = :accountNumber");
        query.setParameter("amount", amount);
        query.setParameter("accountNumber", accountNumber);
        query.executeUpdate();
        transaction.commit();

        return "Updated";
    }


}
