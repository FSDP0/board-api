package com.boardapp.boardapi.user.repository;

import java.util.List;
import com.boardapp.boardapi.user.entity.User;

public interface UserCustomRepository {
    List<User> findAllUser();

    User findByUserId(String userId);
}
