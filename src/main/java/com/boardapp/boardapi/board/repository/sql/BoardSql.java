package com.boardapp.boardapi.board.repository.sql;

public class BoardSql {
    public static final String UPDATE_BY_ID = """
        UPDATE board
        SET board_title = :boardTitle,
            board_contents = :boardContents,
            modify_id = :modifyId,
            modify_date = :modifyDate
        WHERE board_id = :boardId
        """;
}
