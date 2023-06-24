package com.boardapp.boardapi.board.repository;

public class BoardSql {
    protected final static String SELECT_ALL = """
            SELECT *
            FROM boards.board
            """;

    protected final static String SELECT_BY_ID = """
            SELECT *
            FROM boards.board
            WHERE board_id = ?
            """;

    protected final static String INSERT_BOARD = """
            INSERT INTO boards.board(
                board_title,
                user_id,
                board_content,
                created_date
            ) VALUES(?, ?, ?, ?)
            """;

    protected final static String UPDATE_BY_ID = """
            UPDATE boards.board
            SET board_title = ?,
                board_content = ?,
                modified_date = ?
            WHERE board_id = ?
            """;

    protected final static String DELETE_BY_ID = """
            DELETE
            FROM boards.board
            WHERE board_id = ?
            """;
}
