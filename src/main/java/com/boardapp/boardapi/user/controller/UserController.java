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
import com.boardapp.boardapi.user.model.User;
import com.boardapp.boardapi.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> findAllUser() {
        return this.userService.findAllUser();
    }

    @GetMapping("/:{userId}")
    public User findByUserId(@PathVariable String userId) {
        return this.userService.findByUserId(userId);
    }

    @PostMapping
    public String saveUser(@RequestBody User user) {
        return "Effected Row : " + this.userService.saveUser(user);
    }

    @PutMapping("/:{userId}")
    public String updateUser(@PathVariable String userId, @RequestBody User user) {
        return "Effected Row : " + this.userService.updateUser(userId, user);
    }

    @DeleteMapping("/:{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "Effected Row : " + this.userService.deleteUser(userId);
    }
}
