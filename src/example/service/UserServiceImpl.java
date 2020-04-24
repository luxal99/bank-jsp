package example.service;

import example.config.util.DBConfig;
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
}
