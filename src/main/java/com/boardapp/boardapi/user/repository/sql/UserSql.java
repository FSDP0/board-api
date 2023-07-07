package com.boardapp.boardapi.user.repository.sql;

public class UserSql {
    public final static String INSERT_USER = """
            INSERT 
            INTO user (
                user_id,
                user_name,
                user_password,
                user_tel,
                user_address,
                detail_address,
                created_date
            ) VALUES (
                :userId,
                :userName,
                :userPassword,
                :userTel,
                :userAddress,
                :detailAddress,
                :createdDate
            )
            """;

    public final static String UPDATE_BY_ID = """
            UPDATE user
            SET user_name = :userName,
                user_password = userPassword,
                user_tel = :userTel,
                user_address = :userAddress,
                detail_address = :detailAddress,
                modified_date = :modifiedDate
            WHERE user_id = :userId
            """;
}
