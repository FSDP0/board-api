package com.boardapp.boardapi.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.model.User;
import com.boardapp.boardapi.user.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUser() throws Exception {
        return this.userService.getUser();
    }

}
