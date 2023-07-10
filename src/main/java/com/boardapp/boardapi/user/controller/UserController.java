package com.boardapp.boardapi.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.model.dto.UserDto;
import com.boardapp.boardapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    // ! Dependency injection
    private final UserService userService;

    @GetMapping // * 모든 사용자 계정 조회
    public List<UserDto> findAllUser() throws Exception {
        return this.userService.getAllUser();
    }

    @GetMapping("/:{userId}") // * 사용자 아이디를 기준으로 사용자 계정 조회
    public UserDto findUserById(@PathVariable String userId) throws Exception {
        return this.userService.getByUserId(userId);
    }

    @PostMapping // * 사용자 계정 등록
    public void createUser(@RequestBody UserDto dto) throws Exception {
        this.userService.saveUser(dto);
    }

    @PutMapping("/:{userId}") // * 특정 사용자 계정 정보 수정
    public void editUser(@PathVariable String userId, @RequestBody UserDto dto) {
        this.userService.updateUser(userId, dto);
    }

    @DeleteMapping("/:{userId}") // * 특정 사용자 계정 삭제
    public void removeUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);
    }
}
