package com.boardapp.boardapi.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserEditDto;
import com.boardapp.boardapi.user.model.UserResponseDto;
import com.boardapp.boardapi.user.model.UserSaveDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getAllUser() {
        List<User> userList = this.userRepository.findAll();

        if (userList.isEmpty()) {
            log.error("User list empty ...");

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
            log.error("User not found ...");

            return null;
        }

        UserResponseDto dto = UserResponseDto.builder().index(user.getId()).id(user.getUserId())
                .name(user.getUserName()).password(user.getUserPassword())
                .phoneNumber(user.getUserTel()).address(user.getUserAddress())
                .zipcode(user.getAddressZipcode()).createdDate(user.getCreatedDate())
                .modifiedDate(user.getModifiedDate()).build();

        return dto;
    }

    @Transactional
    public void createUser(UserSaveDto dto) {
        this.userRepository.save(dto.toEntity());
    }

    @Transactional
    public void modifyUser(String userId, UserEditDto dto) {
        User prevEntity = this.userRepository.findById(userId).get();

        User user = User.builder().index(prevEntity.getId()).id(userId).name(dto.getName())
                .password(dto.getPassword()).phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress()).zipCode(dto.getZipCode())
                .createdDate(prevEntity.getCreatedDate()).build();

        this.userRepository.save(user);
    }

    @Transactional
    public void removeUser(String userId) {
        this.userRepository.deleteById(userId);
    }
}
