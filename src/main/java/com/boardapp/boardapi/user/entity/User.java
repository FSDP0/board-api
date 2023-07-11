package com.boardapp.boardapi.user.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.user.model.UserResponseDto;
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
    private Date createdDate;

    @Column("modified_date")
    private Date modifiedDate;

    public UserResponseDto toDto(User user){
        return UserResponseDto.builder()
                                .index(user.getId())
                                .id(user.getUserId())
                                .name(user.getUserName())
                                .password(user.getUserPassword())
                                .tel(user.getUserTel())
                                .address(user.getUserAddress())
                                .detailAddress(user.getDetailAddress())
                                .createdDate(user.getCreatedDate())
                                .modifiedDate(user.getModifiedDate())
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
