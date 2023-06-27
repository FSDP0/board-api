package com.boardapp.boardapi.user.repository;

public class UserSQL {
    protected final static String SELECT_ALL = """
            SELECT *
            FROM user
            ORDER BY id ASC
            """;

    protected final static String SELECT_BY_ID = """
            SELECT *
            FROM user
            WHERE user_id = :id
            """;

    protected final static String INSERT_USER = """
            INSERT
            INTO user(
                user_id,
                user_name
                user_password,
                user_tel,
                user_address,
                address_zipcode
            ) VALUES (
                :id,
                :name,
                :password,
                :tel,
                :address,
                :zipcode
            )
            """;

    protected final static String UPDATE_BY_ID = """
            UPDATE user
            SET user_name = :name,
                user_password = :password,
                user_tel = :tel,
                user_address = :address,
                address_zipcode = :zipcode
            WHERE user_id = :id
            """;

    protected final static String DELETE_BY_ID = """
            DELETE
            FROM user
            WHERE user_id = :id
            """;

    protected static String search(String query) {
        StringBuilder queryString = new StringBuilder(SELECT_ALL);

        queryString.append(query);

        return queryString.toString();
    }
}
