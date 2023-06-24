package com.boardapp.boardapi.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        log.info("\\...Serivce");

        List<User> userList = this.userRepository.findAllUsers();

        if (userList.isEmpty()) {
            log.error("Received user list empty ...");

            return null;
        }

        List<UserDto> userDtoList = new ArrayList<UserDto>();

        for (User user : userList) {
            UserDto userDto = UserDto.builder().index(user.getId()).id(user.getUserId())
                    .name(user.getUserName()).password(user.getUserPassword())
                    .phoneNumber(user.getUserTel()).address(user.getUserAddress())
                    .zipCode(user.getAddressZipcode()).createdDate(user.getCreatedDate())
                    .modifiedDate(user.getModifiedDate()).build();

            userDtoList.add(userDto);
        }

        log.info("[ Success Process ] All users data convert to dto");

        return userDtoList;
    }

    public UserDto getUserById(String userId) {
        log.info("\\...Serivce");

        User user = this.userRepository.findUserById(userId);

        if (user == null) {
            log.error("User not exist ...");

            return null;
        }

        UserDto userDto = UserDto.builder().index(user.getId()).id(user.getUserId())
                .name(user.getUserName()).password(user.getUserPassword())
                .phoneNumber(user.getUserTel()).address(user.getUserAddress())
                .zipCode(user.getAddressZipcode()).createdDate(user.getCreatedDate())
                .modifiedDate(user.getModifiedDate()).build();

        log.info("[ Success Process ] User data convert to dto");

        return userDto;
    }

    public void saveUser(UserDto userDto) {
        log.info("\\...Serivce");

        this.userRepository.saveUser(userDto.toEntity());
    }

    public void modifyUser(String userId, UserDto userDto) {
        log.info("\\...Serivce");

        this.userRepository.editUser(userId, userDto.toEntity());
    }

    public void deleteUser(String userId) {
        log.info("\\...Serivce");

        this.userRepository.deleteUser(userId);
    }
}
