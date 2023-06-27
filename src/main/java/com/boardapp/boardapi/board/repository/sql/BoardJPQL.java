package com.boardapp.boardapi.board.repository.sql;

public class BoardJPQL {
        public static final String SELECT_ALL_WITH_JOIN = """
                        SELECT A.boardId AS num,
                               A.boardTitle AS title,
                               A.boardContents AS contents,
                               A.creatorId AS writerId,
                               A.creatorName AS writer,
                               B.userTel AS writerTel,
                               B.userAddress AS writerAddress,
                               B.addressZipcode AS writerAddressZipcode,
                               A.editorId AS editorId,
                               A.editorName AS editor,
                               C.userTel AS editorTel,
                               C.userAddress AS editorAddress,
                               C.addressZipcode AS editorAddressZipcode,
                               A.createdDate AS writeDate,
                               A.modifiedDate AS modifyDate
                        FROM Board A
                        LEFT OUTER JOIN User B
                        ON A.creatorId = B.userId
                        LEFT OUTER JOIN User C
                        ON A.editorId = C.userId
                        ORDER BY A.boardId ASC
                        """;
        public static final String SELECT_BY_ID_WITH_JOIN = """
                        SELECT A.boardId AS num,
                               A.boardTitle AS title,
                               A.boardContents AS contents,
                               A.creatorId AS writerId,
                               A.creatorName AS writer,
                               B.userTel AS writerTel,
                               B.userAddress AS writerAddress,
                               B.addressZipcode AS writerAddressZipcode,
                               A.editorId AS editorId,
                               A.editorName AS editor,
                               C.userTel AS editorTel,
                               C.userAddress AS editorAddress,
                               C.addressZipcode AS editorAddressZipcode,
                               A.createdDate AS writeDate,
                               A.modifiedDate AS modifyDate
                        FROM Board A
                        LEFT OUTER JOIN User B
                        ON A.creatorId = B.userId
                        LEFT OUTER JOIN User C
                        ON A.editorId = C.userId
                        WHERE A.boardId = :id
                        ORDER BY A.boardId ASC
                        """;

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
                            creatorName,
                            createdDate
                        ) VALUES (
                            :#{#boardObj.boardTitle},
                            :#{#boardObj.boardContents},
                            :#{#boardObj.creatorId},
                            :#{#boardObj.creatorName},
                            :#{#boardObj.createdDate}
                        )
                        """;

        public static final String UPDATE_BY_ID = """
                        UPDATE Board A
                        SET boardTitle = :#{#boardObj.boardTitle},
                            boardContents = :#{#boardObj.boardContents},
                            editorId = :#{#boardObj.editorId},
                            editorName = :#{#boardObj.editorName},
                            modifiedDate = :#{#boardObj.modifiedDate}
                        WHERE A.boardId = :id
                        """;

        public static final String DELETE_BY_ID = """
                        DELETE
                        FROM Board A
                        WHERE A.boardId = :id
                        """;
}
