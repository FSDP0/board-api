package com.boardapp.boardapi.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private void findAllUsers() {
        // return this.userService.getAllUser();
    }

    @GetMapping("/:{userId}")
    private void findUserById(@PathVariable String userId) {

    }

    @PostMapping
    private void createUserInfo(@RequestBody String dto) {

    }

    @PutMapping("/:{userId}")
    private void editUserInfo(@PathVariable String userId, @RequestBody String dto) {

    }

    @DeleteMapping("/:{userId}")
    private void deleteUserInfo(@PathVariable String userId) {

    }
}
