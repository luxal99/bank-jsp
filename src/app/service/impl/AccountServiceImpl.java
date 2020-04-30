package app.service.impl;

import app.config.DBConfig;
import app.entity.Account;
import app.entity.AccountTransaction;
import app.entity.TypeOfTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class AccountServiceImpl extends CRUDImpl<Account> {


    public AccountServiceImpl(Class<Account> entityClass) {
        super(entityClass);
    }

    @Override
    public Account save(Account entity) {
        return super.save(entity);
    }

    @Override
    public Account findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<Account> getAll() {
        return super.getAll();
    }

    public String transfer(String accountNumber, Double amount, Account senderAccount, Account receiverAccount) throws Exception {

        if (amount > senderAccount.getBalance()) {
            throw new Exception("");
        } else {
            Session session = DBConfig.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            TransactionServiceImpl<app.entity.Transaction> transactionService = new TransactionServiceImpl<app.entity.Transaction>(app.entity.Transaction.class);
            TransactionTypeServiceImpl<TypeOfTransaction> transactionTypeService = new TransactionTypeServiceImpl<TypeOfTransaction>(TypeOfTransaction.class);
            AccountTransactionServiceImpl<AccountTransaction> accountTransactionService = new AccountTransactionServiceImpl<AccountTransaction>(AccountTransaction.class);

            app.entity.Transaction transactionEntity = new app.entity.Transaction();
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
            senderTransaction.setIdTypeTransaction(payOutTransaction);

            accountTransactionService.save(senderTransaction);

            receiverTransaction.setIdTransaction(transactionEntity);
            receiverTransaction.setIdAccount(receiverAccount);
            receiverTransaction.setIdTypeTransaction(payUpTransaction);

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


    }

    public Account findByAccountNumber(String accountNumber) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createNamedQuery("Account.findByAccountNumber");
        query.setParameter("accountNumber", accountNumber);
        return (Account) query.getSingleResult();
    }
}
