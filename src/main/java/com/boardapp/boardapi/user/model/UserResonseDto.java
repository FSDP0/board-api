package com.boardapp.boardapi.user.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResonseDto {
    private Long index;

    private String id;
    private String name;
    private String password;
    private String tel;
    private String address;
    private String detailAddress;

    private Date createdDate;
    private Date modifiedDate;
}