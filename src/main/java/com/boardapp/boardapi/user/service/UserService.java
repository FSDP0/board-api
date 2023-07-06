package com.boardapp.boardapi.user.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.model.User;
import com.boardapp.boardapi.user.model.dto.UserEditDto;
import com.boardapp.boardapi.user.model.dto.UserResponseDto;
import com.boardapp.boardapi.user.model.dto.UserSaveDto;
import com.boardapp.boardapi.user.repository.master.MasterDatabaseUserMapper;
import com.boardapp.boardapi.user.repository.slave.SlaveDatabaseUserMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    private final MasterDatabaseUserMapper masterDatabaseUserMapper;
    private final SlaveDatabaseUserMapper slaveDatabaseUserMapper;

    public UserService(MasterDatabaseUserMapper masterDatabaseUserMapper, SlaveDatabaseUserMapper slaveDatabaseUserMapper) {
        this.masterDatabaseUserMapper = masterDatabaseUserMapper;
        this.slaveDatabaseUserMapper = slaveDatabaseUserMapper;
    }

    public List<UserResponseDto> getAllUser() {
        List<User> userList = this.slaveDatabaseUserMapper.getAllUser();

        if (userList.isEmpty()) {
            log.error("User list is empty ...");

            return null;
        }

        List<UserResponseDto> dtoList = new ArrayList<UserResponseDto>();

        for (User user : userList) {
            UserResponseDto dto = UserResponseDto.builder().index(user.getIndexId()).id(user.getUserId()).name(user.getUserName())
                    .password(user.getUserPassword()).tel(user.getUserTel()).address(user.getUserAddress())
                    .detailAddress(user.getDetailAddress()).createdDate(user.getCreatedDate()).modifiedDate(user.getModifiedDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    public UserResponseDto getByUserId(String userId) {
        User user = this.slaveDatabaseUserMapper.getByUserId(userId);

        if (user == null) {
            log.error("User is not exist ...");

            return null;
        }

        UserResponseDto dto = UserResponseDto.builder().index(user.getIndexId()).id(user.getUserId()).name(user.getUserName())
                .password(user.getUserPassword()).tel(user.getUserTel()).address(user.getUserAddress())
                .detailAddress(user.getDetailAddress()).createdDate(user.getCreatedDate()).modifiedDate(user.getModifiedDate()).build();

        return dto;
    }

    public void saveUser(UserSaveDto dto) {
        this.masterDatabaseUserMapper.saveUser(dto.toEntity());
    }

    public void updateUser(String userId, UserEditDto dto) {
        User user = User.builder().name(dto.getName()).password(dto.getPassword()).tel(dto.getPhoneNumber()).address(dto.getAddress())
                .detailAddress(dto.getDetailAddress()).modifiedDate(Timestamp.valueOf(LocalDateTime.now())).build();

        this.masterDatabaseUserMapper.updateUser(user, userId);
    }

    public void deleteUser(String userId) {
        this.masterDatabaseUserMapper.deleteUser(userId);
    }
}
