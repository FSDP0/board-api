package com.boardapp.boardapi.user.repository.sql;

public class UserJPQL {
    public static final String UPDATE_BY_ID = """
            UPDATE User A
            SET userName = :#{#userObj.userName},
                userPassword = :#{#userObj.userPassword},
                userTel = :#{#userObj.userTel},
                userAddress = :#{#userObj.userAddress},
                detailAddress = :#{#userObj.detailAddress},
                modifiedDate = :#{#userObj.modifiedDate} 
            WHERE A.userId = :#{#userObj.userId}
            """;
}
