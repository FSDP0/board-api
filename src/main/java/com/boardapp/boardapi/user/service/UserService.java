package com.boardapp.boardapi.user.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserEditDto;
import com.boardapp.boardapi.user.model.UserResponseDto;
import com.boardapp.boardapi.user.model.UserSaveDto;
import com.boardapp.boardapi.user.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getAllUser() {
        List<User> userList = this.userRepository.findAllUser();

        if (userList.isEmpty()) {
            return null;
        }

        List<UserResponseDto> dtoList = new ArrayList<UserResponseDto>();

        for (User user : userList) {
            UserResponseDto dto = UserResponseDto.builder().index(user.getId()).id(user.getUserId())
                    .name(user.getUserName()).password(user.getUserPassword())
                    .phoneNumber(user.getUserTel()).address(user.getUserAddress())
                    .zipcode(user.getAddressZipcode()).createdDate(user.getCreatedDate())
                    .modifiedDate(user.getModifiedDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    public UserResponseDto getUserById(String userId) {
        User user = this.userRepository.findById(userId).get();

        if (user == null) {
            return null;
        }

        UserResponseDto dto = UserResponseDto.builder().index(user.getId()).id(user.getUserId())
                .name(user.getUserName()).password(user.getUserPassword())
                .phoneNumber(user.getUserTel()).address(user.getUserAddress())
                .zipcode(user.getAddressZipcode()).createdDate(user.getCreatedDate())
                .modifiedDate(user.getModifiedDate()).build();

        return dto;
    }

    public void createUser(UserSaveDto dto) {
        this.userRepository.save(dto.toEntity());
    }

    @Transactional
    public void modifyUser(String userId, UserEditDto dto) {
        this.userRepository.updateUser(dto.getUserName(), dto.getUserPassword(), dto.getUserTel(),
                dto.getUserAddress(), dto.getAddressZipcode(),
                Timestamp.valueOf(LocalDateTime.now()), userId);
    }

    @Transactional
    public void removeUser(String userId) {
        this.userRepository.deleteById(userId);
    }

    public Iterable<User> getAllDetail() {
        return this.userRepository.findAll();
    }
}
