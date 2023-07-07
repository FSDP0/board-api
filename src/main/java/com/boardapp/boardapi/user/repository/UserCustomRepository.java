package com.boardapp.boardapi.user.repository;

import com.boardapp.boardapi.user.entity.User;

public interface UserCustomRepository {
    void saveUser(User user);

    void updateUser(User user);
}
