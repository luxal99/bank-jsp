package app.service.impl;

import app.config.DBConfig;
import org.hibernate.Session;

import java.util.List;

public class UserServiceImpl<User> extends CRUDImpl<User> {

    public UserServiceImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public User save(User entity) {
        return super.save(entity);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public String update(User entity) {
        return super.update(entity);
    }

    public User findByUsername(String username) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createNamedQuery("User.findByUsername");
        query.setString("username", username);
        User user = (User) query.getResultList().get(0);
        return user;
    }


}
