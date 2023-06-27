package com.boardapp.boardapi.user.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long index;

    private String userId;
    private String userName;
    private String userPassword;
    private String userTel;

    private String userAddress;
    private String addressZipcode;

    private Date createdDate;

    private Date modifiedDate;

    @Builder
    public UserResponseDto(Long index, String id, String name, String password, String phoneNumber,
            String address, String zipcode, Date createdDate, Date modifiedDate) {
        this.index = index;

        this.userId = id;
        this.userName = name;
        this.userPassword = password;
        this.userTel = phoneNumber;

        this.userAddress = address;
        this.addressZipcode = zipcode;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
