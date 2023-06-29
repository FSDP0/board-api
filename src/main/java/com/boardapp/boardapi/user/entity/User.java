package com.boardapp.boardapi.user.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    private Long id;

    @Id
    private String userId;

    private String userName;
    private String userPassword;
    private String userTel;
    private String userAddress;
    private String addressZipcode;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    @Builder
    public User(String id, String name, String password, String phoneNumber, String adress,
            String zipCode) {
        this.userId = id;
        this.userName = name;
        this.userPassword = password;
        this.userTel = phoneNumber;
        this.userAddress = adress;
        this.addressZipcode = zipCode;
    }

}
