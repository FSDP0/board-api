package com.boardapp.boardapi.user.model;

import lombok.Getter;

@Getter
public class UserEditDto {
    private String name;
    private String password;
    private String phoneNumber;
    private String address;
    private String zipCode;
}
