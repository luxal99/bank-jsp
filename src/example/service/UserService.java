package example.service;

import example.entity.User;

import java.util.List;

public interface UserService {
    public String save(User user);

    public List<User> getAll();

    public User findByUsername(String username);

    public String updateUser(User user);
}
