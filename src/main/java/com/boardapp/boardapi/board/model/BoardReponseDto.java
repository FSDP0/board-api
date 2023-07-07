package com.boardapp.boardapi.board.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import lombok.Builder;
import lombok.Getter;

// * 게시글 정보 데이터 전송객체
@Getter
public class BoardReponseDto {
    private Long num; // 게시글 번호

    private String title; // 게시글 제목
    private String contents; // 게시글 내용

    private String writeName; // 게시글 작성자
    private String modifyName; // 게시글 수정자

    private Date writeDate; // 게시글 작성일
    private Date modifyDate; // 게시글 수정일

    @Builder
    public BoardReponseDto(Long id, String title, String contents, String writeId, String modifyId, Date writeDate, Date modifyDate) {
        this.num = id;

        this.title = title;
        this.contents = contents;

        this.writeName = writeId;
        this.modifyName = modifyId;

        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}
