package com.boardapp.boardapi.user.dao;

import com.boardapp.boardapi.user.model.User;

public interface UserCudDao {
    Integer saveUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(String userId);
}
