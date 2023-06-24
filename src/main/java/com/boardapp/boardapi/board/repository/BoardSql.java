package com.boardapp.boardapi.board.repository;

public class BoardSql {
    protected final static String SELECT_ALL = """
            SELECT *
            FROM boards.board
            """;

    protected final static String SELECT_BY_ID = """
            SELECT *
            FROM boards.board
            WHERE board_id = :board
            """;

    protected final static String INSERT_BOARD = """
            INSERT INTO boards.board(
                board_title,
                user_id,
                board_content,
                created_date
            ) VALUES(
                :boardTitle,
                :userId,
                :boardContent,
                :createdDate
            )
            """;

    protected final static String UPDATE_BY_ID = """
            UPDATE boards.board
            SET board_title = :boardTitle,
                board_content = :boardContent,
                modified_date = :modifiedDate
            WHERE board_id = :boardId
            """;

    protected final static String DELETE_BY_ID = """
            DELETE
            FROM boards.board
            WHERE board_id = :boardId
            """;
}
