package com.boardapp.boardapi.user.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.dao.UserCudDao;
import com.boardapp.boardapi.user.dao.UserReadDao;
import com.boardapp.boardapi.user.model.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServieImpl implements UserService {
    private final UserReadDao userReadDao;
    private final UserCudDao userCudDao;

    @Override
    public List<User> findAllUser() {
        return this.userReadDao.findAllUser();
    }

    @Override
    public User findByUserId(String userId) {
        return this.userReadDao.findByUserId(userId);
    }

    @Override
    public Integer saveUser(User dto) {
        dto.setCreatedDate(LocalDateTime.now());

        return this.userCudDao.saveUser(dto);

    }

    @Override
    public Integer updateUser(String userId, User dto) {
        dto.setUserId(userId);
        dto.setModifiedDate(LocalDateTime.now());

        return this.userCudDao.updateUser(dto);
    }

    @Override
    public Integer deleteUser(String userId) {
        return this.userCudDao.deleteUser(userId);
    }

}
