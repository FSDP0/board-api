package com.boardapp.boardapi.user.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long index;

    private String id;
    private String name;
    private String password;
    private String phoneNumber;
    private String address;
    private String zipCode;

    private Date createdDate;
    private Date modifiedDate;

    @Builder
    public UserResponseDto(Long index, String id, String name, String password, String phoneNumber,
            String address, String zipcode, Date createdDate, Date modifiedDate) {
        this.index = index;

        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipcode;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
