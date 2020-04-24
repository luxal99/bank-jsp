package example.service;

import example.entity.UserType;

import java.util.List;

public interface UserTypeService {
    public List<UserType> getAll();
    public UserType findById(Integer id);
}
