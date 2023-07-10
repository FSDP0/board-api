package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardWithUser {
    private Long boardId;

    // 게시글 기본 정보
    private String boardTitle;
    private String boardContents;

    private String writeId;
    private String modifyId;

    private Date writeDate;
    private Date modifyDate;

    private Long id;

    // 게시글 작성자 정보
    private String creatorName;
    private String creatorTel;
    private String creatorAddress;
    private String creatorDetailAddress;
    private String creatorAddressZipcode;

    // 게시글 수정자 정보
    private String editorName;
    private String editorTel;
    private String editorAddress;
    private String editorDetailAddress;
    private String editorAddressZipcode;

}
