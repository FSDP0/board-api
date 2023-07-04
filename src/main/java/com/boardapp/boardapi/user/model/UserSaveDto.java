package com.boardapp.boardapi.user.model;

import com.boardapp.boardapi.user.entity.User;
import lombok.Getter;

@Getter
public class UserSaveDto {
    private String id;
    private String name;
    private String password;
    private String tel;
    private String address;
    private String detailAddress;

    public User toEntity() {
        User user = User.builder().id(this.id).name(this.name).password(this.password).tel(this.tel).address(this.address)
                .detailAddress(this.detailAddress).build();

        return user;
    }
}
