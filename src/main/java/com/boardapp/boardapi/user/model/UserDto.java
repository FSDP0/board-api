package com.boardapp.boardapi.user.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.boardapp.boardapi.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private Long index;

    private String id;
    private String name;
    private String password;
    private String tel;
    private String address;
    private String detailAddress;

    private Date createdDate;
    private Date modifiedDate;

    // * Convert DTO to Save Entity
    public User toEntity(){
        return User.builder()
                    .userId(this.id)
                    .userName(this.name)
                    .userPassword(this.password)
                    .userTel(this.tel)
                    .userAddress(this.address)
                    .detailAddress(this.detailAddress)
                    .createdDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }

    // * Convert DTO to Update Entity
    public User toEntity(String userId){
        return User.builder()
                    .userId(userId)
                    .userName(this.name)
                    .userPassword(this.password)
                    .userTel(this.tel)
                    .userAddress(this.address)
                    .detailAddress(this.detailAddress)
                    .modifiedDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }
}
