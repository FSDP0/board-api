package com.boardapp.boardapi.user.repository;

public class UserSql {
    protected final static String SELECT_ALL = """
            SELECT A.*, B.user_address, B.address_zipcode
            FROM users.user A
            LEFT OUTER JOIN users.address B
            ON A.user_id = B.user_id
            """;

    protected final static String SELECT_BY_USER_ID = """
            SELECT A.*, B.user_address, B.address_zipcode
            FROM users.user A
            LEFT OUTER JOIN users.address B
            ON A.user_id = B.user_id
            WHERE A.user_id = :userId
            """;

    protected final static String INSERT_USER = """
            INSERT INTO users.user(
                user_id,
                user_name,
                user_password,
                user_tel,
                created_date
            ) VALUES (
                :userId,
                :userName,
                :userPassword,
                :userTel,
                :createdDate
            )
            """;

    protected final static String UPDATE_USER_BY_USER_ID = """
            UPDATE users.user
            SET user_name = :userName,
                user_password = :userPassword,
                user_tel = :userTel,
                modified_date = :modifiedDate
            WHERE user_id = :userId
            """;

    protected final static String DELETE_BY_USER_ID = """
            DELETE
            FROM users.user
            WHERE user_id = :userId
            """;
}
