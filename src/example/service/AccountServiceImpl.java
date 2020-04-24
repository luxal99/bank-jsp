package example.service;

import example.config.util.DBConfig;
import example.entity.Account;
import example.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {


    @Override
    public Account save(Account account) {

        return null;
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
}
