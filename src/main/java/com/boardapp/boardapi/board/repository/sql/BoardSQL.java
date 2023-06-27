package com.boardapp.boardapi.board.repository.sql;

// Native Queries
public class BoardSQL {
    public static final String SELECT_ALL = """
            SELECT *
            FROM board
            """;

    public static final String SELECT_BY_ID = """
            SELECT *
            FROM board
            WHERE board_id = :id
            """;

    public static final String INSERT_BOARD = """
            INSERT
            INTO board(
                board_title,
                board_contents,
                creator_id
            ) VALUES (
                :title
                :contents
                :creatorId
            )
            """;

    public static final String UPDATE_BY_ID = """
            UPDATE board
            SET board_title = :title
                board_contents = :contents
                editor_id = :editorId
            WHERE board_id = :id
            """;

    public static final String DELETE_BY_ID = """
            DELETE
            FROM board
            WHERE board_id = :id
            """;
}
