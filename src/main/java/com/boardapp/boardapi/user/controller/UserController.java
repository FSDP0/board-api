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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "RESTful API Guide for User", description = "사용자 정보 관련 CRUD")
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "Find all user", description = "등록된 모든 사용자목록을 조회합니다.")
    @GetMapping
    private Flux<UserDto> findAllUser(){
        return this.userService.getAllUser();
    }

    @Operation(summary = "Find specific user", description = "등록된 특정 사용자를 사용자 아이디로 조회합니다.")
    @GetMapping("/:{userId}")
    private Mono<UserDto> findByUserId(@PathVariable String userId){
        return this.userService.getByUserId(userId);
    }

    @Operation(summary = "Save user information", description = "새로운 사용자 정보를 등록합니다.")
    @PostMapping
    private Mono<UserDto> saveUser(@RequestBody Mono<UserDto> userDtoMono){
        return this.userService.createUser(userDtoMono);
    }

    @Operation(summary = "Update specific user information", description = "기존 사용자 정보를 갱신합니다.")
    @PutMapping("/:{userId}")
    private Mono<Integer> updateUser(@PathVariable String userId, @RequestBody Mono<UserDto> userDtoMono){
        return this.userService.editUser(userId, userDtoMono);
    }

    @Operation(summary = "Delete specific user information", description = "기존 등록된 사용자 정보를 삭제합니다.")
    @DeleteMapping("/:{userId}")
    private Mono<Void> deleteUser(@PathVariable String userId){
        return this.userService.removeUser(userId);
    }
}
