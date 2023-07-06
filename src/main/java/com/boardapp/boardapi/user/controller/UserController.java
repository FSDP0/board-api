package com.boardapp.boardapi.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.model.UserEditDto;
import com.boardapp.boardapi.user.model.UserResonseDto;
import com.boardapp.boardapi.user.model.UserSaveDto;
import com.boardapp.boardapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    // ! Dependency injection
    private final UserService userService;

    @GetMapping
    private Flux<UserResonseDto> getAllUser(){
        return this.userService.getAllUser();
    }
    
    @GetMapping("/:{userId}")
    private Mono<UserResonseDto> getByUserId(@PathVariable String userId){
        return this.userService.getByUserId(userId);
    }

    @PostMapping
    private Mono<Void> createUser(@RequestBody Mono<UserSaveDto> dtoMono){
        return this.userService.saveUser(dtoMono);
    }

    @PutMapping("/:{userId}")
    private Mono<Void> editUser(@PathVariable String userId,@RequestBody Mono<UserEditDto> dtoMono){
        return this.userService.updateUser(userId, dtoMono);
    }

    @DeleteMapping("/:{userId}")
    private Mono<Void> removeUser(@PathVariable String userId){
        return this.userService.deleteUser(userId);
    }
}
