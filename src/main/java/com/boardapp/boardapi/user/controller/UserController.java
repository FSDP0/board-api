package com.boardapp.boardapi.user.controller;

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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    private Flux<UserDto> findAllUser(){
        return this.userService.getAllUser();
    }

    @GetMapping("/:{userId}")
    private Mono<UserDto> findByUserId(@PathVariable String userId){
        return this.userService.getByUserId(userId);
    }

    @PostMapping
    private Mono<UserDto> saveUser(@RequestBody Mono<UserDto> userDtoMono){
        return this.userService.createUser(userDtoMono);
    }

    @PutMapping("/:{userId}")
    private Mono<UserDto> updateUser(@PathVariable String userId, @RequestBody Mono<UserDto> userDtoMono){
        return this.userService.editUser(userId, userDtoMono);
    }

    @DeleteMapping("/:{userId}")
    private Mono<Void> deleteUser(@PathVariable String userId){
        return this.userService.removeUser(userId);
    }
}
