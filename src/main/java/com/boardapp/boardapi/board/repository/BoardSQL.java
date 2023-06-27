package com.boardapp.boardapi.board.repository;

public class BoardSQL {
        protected static final String SELECT_ALL = """
                        SELECT *
                        FROM board
                        """;

        protected static final String SELECT_BY_ID = """
                        SELECT *
                        FROM board
                        WHERE board_id = :id
                        """;

        protected static final String INSERT_BOARD = """
                        INSERT
                        INTO board (
                                board_title,
                                board_contents,
                                creator_id,
                                creator_name
                        ) VALUES (
                                :title,
                                :contents,
                                :creatorId,
                                :creatorName
                        )
                        """;

        protected static final String UPDATE_BY_ID = """
                        UPDATE board
                        SET board_title = :title,
                            board_contents = :contents,
                            editor_id = :editorId,
                            editor_name = :editorName,
                        WHERE board_id = :id
                        """;

        protected static final String DELETE_BY_ID = """
                        DELETE
                        FROM board
                        WHERE board_id = :id
                        """;

        protected static final String SELECT_BOARD_WITH_USER = """
                        SELECT A.*,B.user_address,B.address_zipcode
                        FROM board A
                        LEFT OUTER JOIN user B
                        ON A.creator_id = B.user_id
                        WHERE A.board_id = :id
                        """;

        protected static final String search(String query) {
                StringBuilder queryString = new StringBuilder(SELECT_ALL);

                queryString.append(query);

                return queryString.toString();
        }
}
