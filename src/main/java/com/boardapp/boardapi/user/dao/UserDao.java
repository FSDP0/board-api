package com.boardapp.boardapi.user.dao;

import java.util.List;
import com.boardapp.boardapi.user.model.User;

public interface UserDao {
    List<User> findAllUser();

    User findByUserId(String userId);

    Integer saveUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(String userId);
}
