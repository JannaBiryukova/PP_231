package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(long userId);

    void updateUser(long id, User user);

    User getUser(long userId);
}

