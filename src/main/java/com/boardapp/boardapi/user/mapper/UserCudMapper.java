package com.boardapp.boardapi.user.mapper;

import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.user.model.User;

public interface UserCudMapper {
    void saveUser(@Param("userObj") User user);

    void updateUser(@Param("userObj") User user);

    void deleteUser(@Param("userId") String userId);
}
