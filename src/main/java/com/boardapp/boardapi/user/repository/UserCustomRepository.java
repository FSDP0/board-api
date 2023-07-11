package com.boardapp.boardapi.user.repository;

import com.boardapp.boardapi.user.entity.User;

public interface UserCustomRepository {
    Integer saveUser(User user);

    Integer updateUser(User user);
}
