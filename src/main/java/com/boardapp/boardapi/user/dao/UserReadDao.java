package com.boardapp.boardapi.user.dao;

import java.util.List;
import com.boardapp.boardapi.user.model.User;

public interface UserReadDao {
    List<User> findAllUser();

    User findByUserId(String userId);
}
