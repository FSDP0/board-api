package com.boardapp.boardapi.board.repository.sql;

public class BoardJPQL {
    public static final String SELECT_ALL = """
            SELECT A
            FROM Board A
            ORDER BY A.boardId ASC
            """;

    public static final String SELECT_BY_ID = """
            SELECT A
            FROM Board A
            WHERE A.boardId = :id
            """;

    public static final String INSERT_BOARD = """
            INSERT
            INTO Board(
                boardTitle,
                boardContents,
                creatorId,
                createdDate
            ) VALUES (
                :#{#boardObj.boardTitle},
                :#{#boardObj.boardContents},
                :#{#boardObj.creatorId},
                :#{#boardObj.createdDate}
            )
            """;

    public static final String UPDATE_BY_ID = """
            UPDATE Board A
            SET boardTitle = :#{#boardObj.boardTitle},
                boardContents = :#{#boardObj.boardContents},
                editorId = :#{#boardObj.editorId},
                modifiedDate = :#{#boardObj.modifiedDate}
            WHERE A.boardId = :id
            """;

    public static final String DELETE_BY_ID = """
            DELETE
            FROM Board A
            WHERE A.boardId = :id
            """;
}
