package web.service;

import web.model.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> listUsers();

    User find(long id);

    User findByEmail(String email);

    void save(User user);

    void update(User user);

    void delete(User user);
}
