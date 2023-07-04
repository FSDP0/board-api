package com.boardapp.boardapi.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.model.User;
import com.boardapp.boardapi.user.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @GetMapping("/:{userId}")
    public void findUserById(@PathVariable String userId) {

    }

    @GetMapping("/detail/:{userId}") // * 특정 사용자가 작성한 게시글 조회
    public void find(@PathVariable String userId) {

    }

    @GetMapping("/detail") // * 특정 사용자가 수정한 게시글 조회
    public void finda(@PathVariable String userId) {

    }

    @PostMapping
    public void saveUser() {

    }

    @PutMapping("/:{userId}")
    public void updateUser(@PathVariable String userId) {

    }

    @DeleteMapping("/:{userId}")
    public void deleteUser(@PathVariable String userId) {

    }
}
