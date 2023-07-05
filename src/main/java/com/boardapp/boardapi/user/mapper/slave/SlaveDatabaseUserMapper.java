package com.boardapp.boardapi.user.mapper.slave;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.user.model.User;

public interface SlaveDatabaseUserMapper {
    List<User> getAllUser();

    User getByUserId(@Param("userId") String userId);
}
