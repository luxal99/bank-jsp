package app.service.dao;

import javax.transaction.Transactional;
import java.util.List;

public interface CRUDService<T> {

    @Transactional
    public T save(T entity);

    @Transactional
    public List<T> getAll();

    @Transactional
    public T findById(Integer id);

    @Transactional
    public String update(T entity);
}
