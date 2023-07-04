package com.boardapp.boardapi.board.repository.sql;

public class BoardSql {
    public static final String SELECT_ALL = """
            SELECT *
            FROM board
            """;

    public static final String SELECT_ALL_ORDERBY = searchOption("ORDER BY", "board_id ASC");

    public static final String SELECT_BY_ID = searchOption("WHERE", "board_id = ?");

    public static final String SELECT_BY_WRITER = searchOption("WHERE", "write_id = ?");

    public static final String SELECT_BY_EDITOR = searchOption("WHERE", "modify_id = ?");

    public static final String UPDATE_BY_ID = """
            UPDATE board
            SET board_title = :title,
                board_contents = :contents,
                modify_id = :modifyId,
                modify_date = :modifyDate
            WHERE board_id = :id
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
