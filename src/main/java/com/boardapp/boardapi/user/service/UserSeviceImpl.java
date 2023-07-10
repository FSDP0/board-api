package com.boardapp.boardapi.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.dao.UserDao;
import com.boardapp.boardapi.user.model.User;
import com.boardapp.boardapi.user.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserSeviceImpl implements UserService{
      // ! Dependency injection 
    private final UserDao userDao;

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = this.userDao.findAll();

        if (userList.isEmpty()) {
            log.error("User list is empty ...");

            return null;
        }

        List<UserDto> dtoList = new ArrayList<UserDto>();

        for (User user : userList) {
            log.debug(user.getIndexId() + " : " + user.getUserId());

            dtoList.add(user.toDto());
        }

        return dtoList;
    }

    @Override
    public UserDto getByUserId(String userId) {
        User user = this.userDao.findById(userId);

        if (user == null) {
            log.error("User is not exist ...");

            return null;
        }

        return user.toDto();
    }

    @Override
    public void saveUser(UserDto dto) {
        this.userDao.saveUser(dto.toEntity());
    }

    @Override
    public void updateUser(String userId, UserDto dto) {
        this.userDao.updateUser(dto.toEntity(userId));
    }

    @Override
    public void deleteUser(String userId) {
        this.userDao.deleteUser(userId);
    }
}
