package app.service.dao;

import javax.transaction.Transactional;
import java.util.List;

public interface CRUDService<T> {

    @Transactional
    public T save(T entity);

    @Transactional
    public List<T> getAll(final Class<T> entityClass);
}
