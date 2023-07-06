package com.boardapp.boardapi.user.repository.slave;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.user.model.User;

public interface SlaveDatabaseUserMapper {
    List<User> getAllUser();

    User getByUserId(@Param("userId") String userId);
}
