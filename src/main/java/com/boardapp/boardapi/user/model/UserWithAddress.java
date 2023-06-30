package com.boardapp.boardapi.user.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserWithAddress {
    private String userId; // PK

    private String userName;

    private String userPassword;

    private String userTel;

    private String detailAddress;

    private String address; // Join Key

    private String addressZipcode;

    @Builder
    public UserWithAddress(String id, String name, String password, String address, String detailAddress, String zipcode) {
        this.userId = id;
        this.userName = name;
        this.userPassword = password;
        this.address = address;
        this.detailAddress = detailAddress;
        this.addressZipcode = zipcode;
    }
}
