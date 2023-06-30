package com.boardapp.boardapi.common.mapper.slave;

import java.util.List;
import com.boardapp.boardapi.user.model.User;

public interface SlaveDatabaseMapper {
    List<User> getAllUser() throws Exception;
}
