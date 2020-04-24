package example.service;

import example.entity.User;

import java.util.List;

public interface UserService {
    public String save(User user);
    public List<User> getAll();
}
