package com.boardapp.boardapi.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Cacheable(cacheNames = "users",cacheManager="userCacheManager")
    public List<UserDto> getAllUser() {
        log.warn("No Cache ...");

        Iterable<User> userList = this.userRepository.findAll();

        List<UserDto> dtoList = new ArrayList<UserDto>();

        for (User user : userList) {
            dtoList.add(user.toDto());
        }

        return dtoList;
    }

    @Cacheable(cacheNames = "users",key="#userId",cacheManager = "userCacheManager")
    public UserDto getByUserId(String userId) {
        log.warn("No Cache ...");

        return this.userRepository.findById(userId).get().toDto();
    }

    @Transactional
    public void saveUser(UserDto dto) {
        this.userRepository.saveUser(dto.toEntity());
    }

    @Transactional
    public void updateUser(String userId, UserDto dto) {
        this.userRepository.updateUser(dto.toEntity(userId));
    }

    @Transactional
    public void deleteUser(String userId) {
        this.userRepository.deleteById(userId);
    }
}
