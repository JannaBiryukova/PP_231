package web.service;

import web.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(long userId);
    void updateUser(long id, User user);
    User getUser(long userId);
}