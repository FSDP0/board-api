package com.boardapp.boardapi.user.service;

import java.util.List;
import com.boardapp.boardapi.user.model.dto.UserDto;

public interface UserService {
    List<UserDto> getAllUser();

    UserDto getByUserId(String userId);

    void saveUser(UserDto userDto);

    void updateUser(String userId, UserDto userDto);

    void deleteUser(String userId);
}
