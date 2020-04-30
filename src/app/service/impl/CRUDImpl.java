package app.service.impl;

import app.config.DBConfig;
import app.service.dao.CRUDService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public abstract class CRUDImpl<T> implements CRUDService {

    @Transactional
    @Override
    public Object save(Object entity) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.Transaction sessionTransaction = session.beginTransaction();
        session.save(entity);
        sessionTransaction.commit();
        session.close();
        return entity;
    }

    @Transactional
    @Override
    public List<T> getAll(Class entityClass) {

        List<T> tList = new ArrayList<>();
        Transaction transaction = null;
        try  {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaQuery<T> tCriteriaQuery = session.getCriteriaBuilder().createQuery(entityClass);
            tCriteriaQuery.select(tCriteriaQuery.from(entityClass));
            tList = session.createQuery(tCriteriaQuery).getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tList;
    }
}
