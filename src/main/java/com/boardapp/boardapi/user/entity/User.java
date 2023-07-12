package com.boardapp.boardapi.user.entity;

import java.util.Date;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.user.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private String userTel;
    private String userAddress;
    private String detailAddress;

    private Date createdDate;
    private Date modifiedDate;

    public UserDto toDto(){
        return UserDto.builder()
                        .build();
    }
}
