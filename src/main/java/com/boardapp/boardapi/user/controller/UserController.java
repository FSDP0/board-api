package com.boardapp.boardapi.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.user.model.dto.UserEditDto;
import com.boardapp.boardapi.user.model.dto.UserResponseDto;
import com.boardapp.boardapi.user.model.dto.UserSaveDto;
import com.boardapp.boardapi.user.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDto> findAllUser() throws Exception {
        return this.userService.getAllUser();
    }

    @GetMapping("/:{userId}")
    public UserResponseDto findUserById(@PathVariable String userId) throws Exception{
        return this.userService.getByUserId(userId);
    }

    // @GetMapping("/detail/:{userId}") // * 특정 사용자가 작성한 게시글 조회
    // public void find(@PathVariable String userId) throws Exception{
    // }

    // @GetMapping("/detail") // * 특정 사용자가 수정한 게시글 조회
    // public void finda(@PathVariable String userId) throws Exception{

    // }

    @PostMapping
    public void saveUser(@RequestBody UserSaveDto dto) throws Exception{
        this.userService.saveUser(dto);
    }

    @PutMapping("/:{userId}")
    public void updateUser(@PathVariable String userId,@RequestBody UserEditDto dto) {
        this.userService.updateUser(userId, dto);
    }

    @DeleteMapping("/:{userId}")
    public void deleteUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);
    }
}
