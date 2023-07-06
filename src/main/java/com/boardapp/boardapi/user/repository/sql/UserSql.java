package com.boardapp.boardapi.user.repository.sql;

public class UserSql {
    public static final String SELECT_ALL = """
            SELECT *
            FROM user
            """;

    public static final String SELECT_ALL_ORDERBY = searchOption("ORDER BY", "id ASC");

    public static final String SELECT_BY_ID = searchOption("WHERE", "user_id = :userId");

    public static final String UPDATE_BY_ID = """
            UPDATE user
            SET user_name = :userName,
                user_password = :userPassword,
                user_tel = :userTel,
                user_address = :userAddress,
                detail_address = :detailAddress,
                modified_date = :modifiedDate
            WHERE user_id = :userId
            """;

    public static final String INSERT_USER = """
            INSERT
            INTO user(
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

    public static String searchOption(String command, String query) {
        // * String build example
        // * [ command ] : WHERE
        // * [ query ] : board_id = ?
        // * --------------------------------------
        // * [ queryString ] : \nWHERE board_id = ?

        StringBuilder queryString = new StringBuilder(SELECT_ALL);

        queryString.append("\n");
        queryString.append(command);

        queryString.append(" ");
        queryString.append(query);

        return queryString.toString();
    }
}
