package com.boardapp.boardapi.user.model;

import lombok.Getter;

@Getter
public class UserEditDto {
    private String name;
    private String password;
    private String tel;
    private String address;
    private String detailAddress;
}
