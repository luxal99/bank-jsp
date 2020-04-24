package example.service;

import example.config.util.DBConfig;
import example.entity.Account;
import example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserServiceImpl implements  UserService {

    @Override
    public String save(User user) {
        Session session = DBConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        return "Saved";
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createNamedQuery("User.findByUsername");
        query.setString("username",username);
        User user = (User) query.getResultList().get(0);
        return user;
    }
}
