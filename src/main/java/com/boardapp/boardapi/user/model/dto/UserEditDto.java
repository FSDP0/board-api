package com.boardapp.boardapi.user.model.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.user.model.User;
import lombok.Getter;

@Getter
public class UserEditDto {
    private String name;
    private String password;
    private String phoneNumber;
    private String address;
    private String detailAddress;

    public User toEntity() {
        User user = User.builder().name(this.name).password(this.password).tel(this.phoneNumber).address(this.address)
                .detailAddress(this.detailAddress).modifiedDate(Timestamp.valueOf(LocalDateTime.now())).build();

        return user;
    }
}
