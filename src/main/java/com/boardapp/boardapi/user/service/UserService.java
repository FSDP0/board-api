package com.boardapp.boardapi.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserPayload;
import com.boardapp.boardapi.user.repository.AddressRepository;
import com.boardapp.boardapi.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public void getAllUser() {
        // List<User> userList = this.userRepository.findAll();

        // if (userList.isEmpty()) {
        // log.error("User list empty ...");

        // return null;
        // }

        // List<UserPayload> userDtoList = new ArrayList<UserPayload>();

        // for (User user : userList) {
        // UserPayload userDto = UserPayload.builder().id(user.getUserId()) // 사용자 아이디
        // .name(user.getUserName()) // 사용자 이름
        // .password(user.getUserPassword()) // 사용자 비밀번호
        // .phoneNumber(user.getUserTel()) // 사용자 전화번호
        // .address(user.getUserAddress()) // 사용자 주소
        // .zipCode(user.getAddressZipcode()) // 사용자 주소 Zip Code
        // .build();

        // userDtoList.add(userDto);
        // }

        // return userDtoList;
    }

    public void getUserById(Long id) {}

    @Transactional
    public void createUser() {

    }

    @Transactional
    public void modifyUser(String userId, String dto) {

    }

    @Transactional
    public void removeUser(String userId) {

    }
}
