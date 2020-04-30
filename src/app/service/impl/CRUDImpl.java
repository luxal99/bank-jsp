package app.service.impl;

import app.config.DBConfig;
import app.service.dao.CRUDService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public abstract class CRUDImpl<T> implements CRUDService<T> {

    private final Class<T> entityClass;

    public CRUDImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    @Transactional
    @Override
    public T save(T entity) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.Transaction sessionTransaction = session.beginTransaction();
        session.save(entity);
        sessionTransaction.commit();
        session.close();
        return entity;
    }

    @Transactional
    @Override
    public T findById(Integer id) {
        T t = null;
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            t = session.find(this.entityClass, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    @Transactional
    @Override
    public List<T> getAll() {

        List<T> tList = new ArrayList<>();
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaQuery<T> tCriteriaQuery = session.getCriteriaBuilder().createQuery(this.entityClass);
            tCriteriaQuery.select(tCriteriaQuery.from(this.entityClass));
            tList = session.createQuery(tCriteriaQuery).getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tList;
    }

    @Override
    public String update(T entity) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.Transaction sessionTransaction = session.beginTransaction();
        session.update(entity);
        sessionTransaction.commit();
        session.close();
        return "Updated";
    }
}
