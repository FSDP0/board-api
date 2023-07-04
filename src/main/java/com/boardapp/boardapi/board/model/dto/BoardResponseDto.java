package com.boardapp.boardapi.board.model.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

// * Basic response dto
@Getter
public class BoardResponseDto {
    private Long num;

    private String title;
    private String contents;

    private String writeName;
    private String modifyName;

    private Date writeDate;
    private Date modifyDate;

    @Builder
    public BoardResponseDto(Long id, String title, String contents, String writeId, String modifyId, Date writeDate, Date modifyDate) {
        this.num = id;
        this.title = title;
        this.contents = contents;
        this.writeName = writeId;
        this.modifyName = modifyId;
        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}
