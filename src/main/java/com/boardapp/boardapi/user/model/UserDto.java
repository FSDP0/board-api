package com.boardapp.boardapi.user.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.boardapp.boardapi.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long index;

    private String id;
    private String name;
    private String password;
    private String tel;

    private String address;
    private String detailAddress;
    private String addressZipcode;

    private Date createdDate;
    private Date modifiedDate;

    public User toUserEntity(){
        return User.builder()
                    .userId(this.id)
                    .userName(this.name)
                    .userPassword(this.password)
                    .userTel(this.tel)
                    .userAddress(this.address)
                    .detailAddress(this.detailAddress)
                    .build();
    }

    public User toUserEntity(String userId){
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
