package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long num;

    private String title;
    private String contents;

    private String writeId;
    private String writeName;

    private String modifyId;
    private String modifyName;

    private Date writeDate;
    private Date modifyDate;

    @Builder
    public BoardResponseDto(Long num, String title, String contents, String writeId,
            String writeName, String modifyId, String modifyName, Date writeDate, Date modifyDate) {
        this.num = num;

        this.title = title;
        this.contents = contents;

        this.writeId = writeId;
        this.writeName = writeName;

        this.modifyId = modifyId;
        this.modifyName = modifyName;

        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}
