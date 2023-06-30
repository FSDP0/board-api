package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // 모든 멤버 변수를 매개로 받는 생성자 설정
@Getter
public class BoardWithEditor {
    private Long boardId;

    // 게시글 기본 정보
    private String boardTitle;
    private String boardContents;
    private String writeId;
    private String modifyId;

    private Date writeDate;
    private Date modifyDate;

    // 게시글 수정자 정보
    private String editorName;
    private String editorTel;
    private String editorAddress;
    private String editorDetailAddress;
    private String editorAddressZipcode;
}
