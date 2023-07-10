package com.boardapp.boardapi.user.mapper;

import java.util.List;
import com.boardapp.boardapi.user.model.User;

public interface UserReadMapper {
    List<User> getAllUser();

    User getByUserId(String userId);
}
