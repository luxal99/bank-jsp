package app.service.dao;

import app.entity.User;

import java.util.List;

public interface UserService {
    String save(User user);

    List<User> getAll();

    User findByUsername(String username);

    String updateUser(User user);
}
