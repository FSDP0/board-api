package com.boardapp.boardapi.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getAllUser(){
        Iterable<User> userList = this.userRepository.findAll();
        
        List<UserDto> dtoList = new ArrayList<UserDto>();

        for(User user: userList) {
            dtoList.add(user.toDto());
        }

        return dtoList;
    }

    public UserDto getByUserId(String userId) {
        return this.userRepository.findById(userId).get().toDto();
    }

    public void createUser(UserDto dto){
        this.userRepository.save(dto.toEntity());
    }

    public void editUser(String userId,UserDto dto){
        this.userRepository.save(dto.toEntity(userId));
    }

    public void removeUser(String userId){
        this.userRepository.deleteById(userId);
    }
}
