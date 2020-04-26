package app.service.impl;

import app.config.DBConfig;
import app.entity.UserType;
import app.service.dao.UserTypeService;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserTypeServiceImpl implements UserTypeService {

    @Override
    public List<UserType> getAll() {
        List<UserType> userTypeList = new ArrayList();
        Session session = DBConfig.getSessionFactory().openSession();

        Query query = session.createNamedQuery("UserType.findAll");
        userTypeList = query.getResultList();
        return userTypeList;
    }

    @Override
    public UserType findById(Integer id) {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createNamedQuery("UserType.findByIdUserType");
        query.setInteger("idUserType",id);
        UserType userType = (UserType) query.getResultList().get(0);
        return userType;
    }
}
