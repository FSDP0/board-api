package com.boardapp.boardapi.user.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 동일한 패키지 내에서만 매개변수가 없는 생성자로 Class Object 생성 가능
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    private Long index;

    private String userId; // PK

    private String userName;

    private String userPassword;

    private String userTel;

    private String address;

    private String detailAddress;

    @Builder
    public User(String id, String name, String password, String tel, String address, String detailAddress) {
        this.userId = id;
        this.userName = name;
        this.userPassword = password;
        this.userTel = tel;
        this.detailAddress = detailAddress;
    }
}
