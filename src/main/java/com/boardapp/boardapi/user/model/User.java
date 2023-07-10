package com.boardapp.boardapi.user.model;

import java.util.Date;
import com.boardapp.boardapi.user.model.dto.UserDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 동일한 패키지 내에서만 매개변수가 없는 생성자로 Class Object 생성 가능
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private Long indexId; // UK 

    private String userId; // PK
    private String userName;
    private String userPassword;
    private String userTel;
    
    private String userAddress;
    private String detailAddress;
    
    private Date createdDate;
    private Date modifiedDate;

    public UserDto toDto() {
        return UserDto.builder()
                        .index(this.indexId)
                        .id(this.userId)
                        .name(this.userName)
                        .password(this.userPassword)
                        .tel(this.userTel)
                        .address(this.userAddress)
                        .detailAddress(this.detailAddress)
                        .createdDate(this.createdDate)
                        .modifiedDate(this.modifiedDate)
                        .build();
    }

    @Builder
    public User(String id, String name, String password, String tel, String address, String detailAddress, Date createdDate,
            Date modifiedDate) {
        this.userId = id;
        this.userName = name;
        this.userPassword = password;
        this.userTel = tel;
        this.userAddress = address;
        this.detailAddress = detailAddress;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
