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
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    private List<UserDto> findAllUser() {
        return this.userService.getAllUser();
    }

    @GetMapping("/:{userId}")
    private UserDto findByUserId(@PathVariable String userId) {
        return this.userService.getByUserId(userId);
    }

    @PostMapping
    private void saveUser(@RequestBody UserDto dto) {
        this.userService.createUser(dto);
    }

    @PutMapping("/:{userId}")
    private void updateUser(@PathVariable String userId, @RequestBody UserDto dto) {
        this.userService.editUser(userId, dto);
    }

    @DeleteMapping("/:{userId}")
    private void deleteUser(@PathVariable String userId){
        this.userService.removeUser(userId);
    }
}
