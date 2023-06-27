package com.boardapp.boardapi.board.repository.sql;

public class BoardSQL {
        public static final String SELECT_ALL = """
                        SELECT A.*,
                               B.user_id,
                               B.user_name,
                               B.user_tel,
                               B.user_address,
                               B.address_zipcode
                        FROM board A
                        LEFT OUTER JOIN user B
                        ON A.creator_id = B.user_id
                        """;

        public static final String SELECT_BY_ID = """
                        SELECT A.*,
                               B.user_id,
                               B.user_name,
                               B.user_tel,
                               B.user_address,
                               B.address_zipcode
                        FROM board A
                        LEFT OUTER JOIN user B
                        ON A.creator_id = B.user_id
                        WHERE A.creator_id = :id
                        """;

        public static final String UPDATE_BY_ID = """
                        UPDATE board
                        SET board_title = :title,
                            board_contents = :contents,
                            editor_id = :editorId,
                            editor_name = :editorName,
                        WHERE board_id = :id
                        """;
}
