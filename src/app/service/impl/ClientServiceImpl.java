package app.service.impl;

import java.util.List;

public class ClientServiceImpl<Client> extends CRUDImpl<Client> {

    public ClientServiceImpl(Class<Client> entityClass) {
        super(entityClass);
    }

    @Override
    public Client save(Client entity) {
        return super.save(entity);
    }

    @Override
    public Client findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<Client> getAll() {
        return super.getAll();
    }

    @Override
    public String update(Client entity) {
        return super.update(entity);
    }
}
