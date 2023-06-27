package com.boardapp.boardapi.user.model;

import com.boardapp.boardapi.user.entity.User;
import lombok.Getter;

@Getter
public class UserSaveDto {
    private String userId;
    private String userName;
    private String userPassword;
    private String userTel;

    private String userAddress;
    private String addressZipcode;

    public User toEntity() {
        User user = User.builder().id(this.userId).name(this.userName).password(this.userPassword)
                .phoneNumber(this.userTel).adress(this.userAddress).zipCode(this.addressZipcode)
                .build();

        return user;
    }
}
