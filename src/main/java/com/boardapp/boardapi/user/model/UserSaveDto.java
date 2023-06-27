package com.boardapp.boardapi.user.model;

import com.boardapp.boardapi.user.entity.User;
import lombok.Getter;

@Getter
public class UserSaveDto {
    private String id;
    private String name;
    private String password;
    private String phoneNumber;
    private String address;
    private String zipCode;

    public User toEntity() {
        User user = User.builder().id(this.id).name(this.name).password(this.password)
                .phoneNumber(this.phoneNumber).address(this.address).zipCode(this.zipCode).build();

        return user;
    }
}
