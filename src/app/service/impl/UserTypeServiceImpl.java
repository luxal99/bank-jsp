package app.service.impl;

import java.util.List;

public class UserTypeServiceImpl<UserType> extends CRUDImpl<UserType> {

    public UserTypeServiceImpl(Class<UserType> entityClass) {
        super(entityClass);
    }

    @Override
    public UserType findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<UserType> getAll() {
        return super.getAll();
    }
}
