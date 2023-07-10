package com.boardapp.boardapi.user.dao;

import java.util.List;
import com.boardapp.boardapi.user.model.User;

public interface UserDao {
    List<User> findAll();

    User findById(String userId);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(String userId);
}
