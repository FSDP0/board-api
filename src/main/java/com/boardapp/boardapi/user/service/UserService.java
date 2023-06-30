package com.boardapp.boardapi.user.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.common.mapper.slave.SlaveDatabaseMapper;
import com.boardapp.boardapi.user.model.User;

@Service
public class UserService {
    private final SlaveDatabaseMapper slaveDatabaseMapper;

    public UserService(SlaveDatabaseMapper slaveDatabaseMapper) {
        this.slaveDatabaseMapper = slaveDatabaseMapper;
    }

    public List<User> getUser() throws Exception {
        return this.slaveDatabaseMapper.getAllUser();
    }
}
