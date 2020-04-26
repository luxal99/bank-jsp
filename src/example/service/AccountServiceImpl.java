package example.service;

import example.config.util.DBConfig;
import example.entity.Account;
import example.entity.TypeOfTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
        return (Account) query.getSingleResult();
    }

    @Override
    public String payUp(String accountNumber, Double amount, Account account) {

        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        TransactionService transactionService = new TransactionServiceImpl();
        TransactionTypeService transactionTypeService = new TransactionTypeServiceImpl();

        org.hibernate.query.Query query = session.createQuery("update Account set balance = balance+ :amount where accountNumber = :accountNumber");
        query.setParameter("amount", amount);
        query.setParameter("accountNumber", accountNumber);
        query.executeUpdate();
        transaction.commit();
        session.close();

        example.entity.Transaction transactionEntity = new example.entity.Transaction();
        TypeOfTransaction typeOfTransaction = transactionTypeService.findByType("payup");

        Date date = new Date();

        transactionEntity.setDate(date);
        transactionEntity.setAmount(amount);
        transactionEntity.setIdAccount(account);
        transactionEntity.setTypeOfTransaction(typeOfTransaction);


        transactionService.save(transactionEntity);


        return "Updated";
    }


}
