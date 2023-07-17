package com.boardapp.boardapi.user.service;

import java.util.List;
import com.boardapp.boardapi.user.model.User;

public interface UserService {
    List<User> findAllUser();

    User findByUserId(String userId);

    Integer saveUser(User dto);

    Integer updateUser(String userId, User dto);

    Integer deleteUser(String userId);
}
