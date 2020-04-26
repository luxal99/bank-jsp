package example.service;

import example.config.util.DBConfig;
import example.entity.Account;
import example.entity.AccountTransaction;
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
        List<Account> accountList = new ArrayList();
        Session session = DBConfig.getSessionFactory().openSession();

        Query query = session.createNamedQuery("Account.findAll");
        accountList = query.getResultList();

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getIdClient() == null) accountList.remove(i);
        }
        return accountList;
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
    public String transfer(String accountNumber, Double amount, Account senderAccount, Account receiverAccount) {

        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        TransactionService transactionService = new TransactionServiceImpl();
        TransactionTypeService transactionTypeService = new TransactionTypeServiceImpl();
        AccountTransactionService accountTransactionService = new AccountTransactionServiceImpl();
        AccountService accountService = new AccountServiceImpl();


        example.entity.Transaction transactionEntity = new example.entity.Transaction();
        TypeOfTransaction payUpTransaction = transactionTypeService.findByType("payup");
        TypeOfTransaction payOutTransaction = transactionTypeService.findByType("payout");
        AccountTransaction senderTransaction = new AccountTransaction();
        AccountTransaction receiverTransaction = new AccountTransaction();

        Date date = new Date();

        transactionEntity.setDate(date);
        transactionEntity.setAmount(amount);

        transactionService.save(transactionEntity);

        senderTransaction.setIdTransaction(transactionEntity);
        senderTransaction.setIdAccount(senderAccount);
        senderTransaction.setIdTypeTransaction(payUpTransaction);

        accountTransactionService.save(senderTransaction);

        receiverTransaction.setIdTransaction(transactionEntity);
        receiverTransaction.setIdAccount(receiverAccount);
        receiverTransaction.setIdTypeTransaction(payOutTransaction);

        accountTransactionService.save(receiverTransaction);

        org.hibernate.query.Query queryIncrease = session.createQuery("update Account set balance = balance + :amount where accountNumber = :receiverAccount");
        org.hibernate.query.Query queryDecrease = session.createQuery("update Account set balance = balance - :amount where accountNumber = :senderAccount");

        queryIncrease.setParameter("amount", amount);
        queryIncrease.setParameter("receiverAccount", receiverAccount.getAccountNumber());

        queryIncrease.executeUpdate();

        queryDecrease.setParameter("amount", amount);
        queryDecrease.setParameter("senderAccount", senderAccount.getAccountNumber());

        queryDecrease.executeUpdate();
        transaction.commit();
        session.close();

        return "Updated";
    }


    @Override
    public List<Account> findAccountByIdClient(Integer id) {
        return null;
    }
}
