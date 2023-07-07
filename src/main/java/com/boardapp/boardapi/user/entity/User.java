package com.boardapp.boardapi.user.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.user.model.UserDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table("user")
public class User {
    @Column("id")
    private Long id;

    @Id
    @Column("user_id")
    private String userId;

    @Column("user_name")
    private String userName;

    @Column("user_password")
    private String userPassword;

    @Column("user_tel")
    private String userTel;

    @Column("user_address")
    private String userAddress;

    @Column("detail_address")
    private String detailAddress;

    @Column("created_date")
    private Date createdDate;

    @Column("modified_date")
    private Date modifiedDate;

    public UserDto toDto(){
        return UserDto.builder()
                        .index(this.id)
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
    public User(String id, String name, String password, String tel, String addess, String detailAddress, Date createdDate,
            Date modifiedDate) {
        this.userId = id;
        this.userName = name;
        this.userPassword = password;
        this.userTel = tel;
        this.userAddress = addess;
        this.detailAddress = detailAddress;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
