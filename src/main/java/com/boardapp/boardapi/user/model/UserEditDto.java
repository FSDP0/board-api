package com.boardapp.boardapi.user.model;

import lombok.Getter;

@Getter
public class UserEditDto {
    private String userName;
    private String userPassword;
    private String userTel;

    private String userAddress;
    private String addressZipcode;

    // public User toEntity(String userId) {
    // User user = User.builder().id(userId).name(this.userName).password(this.userPassword)
    // .phoneNumber(this.userTel).adress(this.userAddress).zipCode(this.addressZipcode)
    // .build();

    // return user;
    // }
}
