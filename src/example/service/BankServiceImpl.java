package example.service;

import example.config.util.DBConfig;
import example.entity.Bank;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class BankServiceImpl implements BankService {
    @Override
    public Bank findBankById(Integer id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createNamedQuery("Bank.findByIdBank");
        query.setParameter("idBank", id);
        return (Bank) query.getSingleResult();
    }
}
