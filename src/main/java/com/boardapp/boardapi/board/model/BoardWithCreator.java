package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // 모든 멤버 변수를 매개로 받는 생성자 설정
@Getter
public class BoardWithCreator {
    private Long boardId;

    // 게시글 기본 정보
    private String boardTitle;
    private String boardContents;
    private String writeId;
    private String modifyId;

    private Date writeDate;
    private Date modifyDate;

    // 게시글 작성자 정보
    private String creatorName;
    private String creatorTel;
    private String creatorAddress;
    private String creatorDetailAddress;
    private String creatorAddressZipcode;
}
