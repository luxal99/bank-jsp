package app.service.dao;

import app.entity.UserType;

import java.util.List;

public interface UserTypeService {
    List<UserType> getAll();
    UserType findById(Integer id);
}
