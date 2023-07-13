package com.boardapp.boardapi.board.repository.sql;

public class BoardJPQL {
    public static final String UPDATE_BY_ID = """
            UPDATE Board A
            SET boardTitle = :#{#boardObj.boardTitle},
                boardContents = :#{#boardObj.boardContents},
                editorId = :#{#boardObj.editorId},
                modifiedDate = :#{#boardObj.modifiedDate}
            WHERE A.boardId = :#{#boardObj.boardId}
            """;
}
