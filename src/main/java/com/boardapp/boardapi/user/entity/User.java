package com.boardapp.boardapi.user.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
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
    @CreatedDate
    private Date createdDate;

    @Column("modified_date")
    @LastModifiedDate
    private Date modifiedDate;

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

    public String toString() {
        return "" + this.userId + " " + this.userPassword + " " + this.userTel + " " + this.detailAddress + " " + this.createdDate + " "
                + this.modifiedDate;
    }
}
