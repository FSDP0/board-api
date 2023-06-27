package com.boardapp.boardapi.board.repository;

public class BoardJPQL {
        public static final String SELECT_ALL = """
                        SELECT A
                        FROM Board A
                        JOIN FETCH A.creatorId B
                        ORDER BY A.boardId ASC
                        """;

        public static final String SELECT_BY_ID = """
                        SELECT A
                        FROM Board A
                        JOIN FETCH A.creatorId B
                        WHERE A.boardId = :id
                        """;

        public static final String INSERT_BOARD = """
                        INSERT
                        INTO Board(
                            boardTitle,
                            boardContents,
                            creatorId
                        ) VALUES (
                            :#{#boardObj.boardTitle},
                            :#{#boardObj.boardContents},
                            :#{#boardObj.creatorId}
                        )
                        """;

        public static final String UPDATE_BY_ID = """
                        UPDATE Board A
                        SET boardTitle = :#{#boardObj.boardTitle},
                            boardContents = :#{#boardObj.boardContents},
                            editorId = :#{#boardObj.editorId}
                        WHERE A.boardId = :id
                        """;

        public static final String DELETE_BY_ID = """
                        DELETE
                        FROM Board A
                        WHERE A.boardId = :id
                        """;
}
