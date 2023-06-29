package com.boardapp.boardapi.user.model;

import lombok.Getter;

@Getter
public class UserEditDto {
    private String userName;
    private String userPassword;
    private String userTel;

    private String userAddress;
    private String addressZipcode;

}
