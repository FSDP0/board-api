package com.boardapp.boardapi.user.model;

import java.util.Date;
import com.boardapp.boardapi.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
    private Long index;             // ! UK [ Long Type Column ]

    private String id;              // ! PK [ VARCHAR Type Column ]
    private String name;
    private String password;
    private String tel;
    private String address;
    private String detailAddress;

    private Date createdDate;
    private Date modifiedDate;

    // * Convert to Save Entity
    // * Injection UserId Parameter with requested JSON data
    public User toEntity() {
        return User.builder()
                    .id(this.id)
                    .name(this.name)
                    .password(this.password)
                    .tel(this.tel)
                    .addess(this.address)
                    .detailAddress(this.detailAddress)
                    .build();
    }

    // * Convert to Update Entity
    // * Injection UserId Parameter from received argument
    public User toEntity(String userId) {
        return User.builder()
                    .id(userId)
                    .name(this.name)
                    .password(this.password)
                    .tel(this.tel)
                    .addess(this.address)
                    .detailAddress(this.detailAddress)
                    .build();
    }
}
