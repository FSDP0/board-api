package com.boardapp.boardapi.user.repository.sql;

public class UserSql {
    public static final String SELECT_ALL = """
            SELECT *
            FROM user
            """;

    public static final String SELECT_ALL_ORDERBY = searchOption("ORDER BY", "id ASC");

    public static final String SELECT_BY_ID = searchOption("WHERE", "user_id = ?");

    public static final String UPDATE_BY_ID = """
            UPDATE user
            SET user_name = :name,
                user_password = :password,
                user_tel = :tel,
                user_address = :address,
                detail_address = :detailAddress
            WHERE user_id = :id
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
