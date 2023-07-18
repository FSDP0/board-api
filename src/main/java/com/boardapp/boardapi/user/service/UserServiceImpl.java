package com.boardapp.boardapi.user.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.dao.UserDao;
import com.boardapp.boardapi.user.model.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    @Override
    public List<User> findAllUser() {
        return this.userDao.findAllUser();
    }

    @Override
    public User findByUserId(String userId) {
        return this.userDao.findByUserId(userId);
    }

    @Override
    public Integer saveUser(User dto) {
        dto.setCreatedDate(LocalDateTime.now());

        return this.userDao.saveUser(dto);
    }

    @Override
    public Integer updateUser(String userId, User dto) {
        dto.setUserId(userId);
        dto.setModifiedDate(LocalDateTime.now());
        
        return this.userDao.updateUser(dto);
    }

    @Override
    public Integer deleteUser(String userId) {
        return this.userDao.deleteUser(userId);
    }
    
}
