package com.boardapp.boardapi.user.model.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.boardapp.boardapi.user.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {
    private Long index;    

    private String id;              // ! This member field exist for response
    private String name;
    private String password;
    private String tel;
    private String address;
    private String detailAddress;

    private Date createdDate;
    private Date modifiedDate;

    // ! Convert DTO to Save Entity using Builder
    public User toEntity() {
        return User.builder()
                    .name(this.name)
                    .password(this.password)
                    .tel(this.tel)
                    .address(this.address)
                    .detailAddress(this.detailAddress)
                    .createdDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }

    // ! Convert DTO to Update Entity using Builder
    public User toEntity(String userId) {
        return User.builder()
                    .id(userId)
                    .name(this.name)
                    .password(this.password)
                    .tel(this.tel)
                    .address(this.address)
                    .detailAddress(this.detailAddress)
                    .modifiedDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }
}
