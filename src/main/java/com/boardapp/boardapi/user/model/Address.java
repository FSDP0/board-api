package com.boardapp.boardapi.user.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 동일한 패키지 내에서만 매개변수가 없는 생성자로 Class Object 생성 가능
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Address {
    private String address; // PK

    private String addressZipcode;

    @Builder
    public Address(String address, String zipcode) {
        this.address = address;
        this.addressZipcode = zipcode;
    }
}
