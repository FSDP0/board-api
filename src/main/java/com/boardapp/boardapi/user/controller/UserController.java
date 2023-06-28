package com.boardapp.boardapi.user.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.model.UserEditDto;
import com.boardapp.boardapi.user.model.UserResponseDto;
import com.boardapp.boardapi.user.model.UserSaveDto;
import com.boardapp.boardapi.user.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<UserResponseDto> findAllUser() {
        return this.userService.getAllUser();
    }

    @GetMapping("/:{userId}")
    private UserResponseDto findUserById(@PathVariable String userId) {
        return this.userService.getUserById(userId);
    }

    @PostMapping
    private void saveUser(@RequestBody UserSaveDto dto) {
        this.userService.createUser(dto);
    }

    @PutMapping("/:{userId}")
    private void editUser(@PathVariable String userId, @RequestBody UserEditDto dto) {
        this.userService.modifyUser(userId, dto);
    }

    @DeleteMapping("/:{userId}")
    private void deleteUser(@PathVariable String userId) {
        this.userService.removeUser(userId);
    }

    @GetMapping("/test")
    private Iterable<Object> sample() {
        return this.userService.sample();
    }
}
