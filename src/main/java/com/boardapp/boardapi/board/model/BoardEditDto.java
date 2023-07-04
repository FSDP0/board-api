package com.boardapp.boardapi.board.model;

import lombok.Getter;

// * 게시글 수정관련 데이터 전송객체
@Getter
public class BoardEditDto {
    private String title;
    private String contents;

    private String modifyName; // Modify User ID value here
}
