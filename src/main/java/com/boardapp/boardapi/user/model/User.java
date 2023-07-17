package com.boardapp.boardapi.user.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long indexId;

    private String userId;
    private String userName;
    private String userPassword;
    private String userPhonenumber;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
