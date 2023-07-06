package com.boardapp.boardapi.user.repository.master;

import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.user.model.User;

public interface MasterDatabaseUserMapper {
    void saveUser(@Param("userObj") User user);

    void updateUser(@Param("userObj") User user, @Param("userId") String userId);

    void deleteUser(@Param("userId") String userId);
}
