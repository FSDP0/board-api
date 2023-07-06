package com.boardapp.boardapi.user.repository;

import com.boardapp.boardapi.user.entity.User;

public interface UserCustomRepository {
    Integer saveBoard(User user);

    Integer updateBoard(User user);
}
