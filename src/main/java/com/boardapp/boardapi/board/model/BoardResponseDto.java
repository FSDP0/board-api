package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

// Matching with Tymeleaf template variables
@Getter
public class BoardResponseDto {
    private Long num;

    private String title;
    private String writeName;
    private String contents;

    private Date writeDate;
    private Date modifyDate;

    @Builder
    public BoardResponseDto(Long id, String title, String writer, String contents, Date createdDate,
            Date modifiedDate) {
        this.num = id;

        this.title = title;
        this.writeName = writer;
        this.contents = contents;

        this.writeDate = createdDate;
        this.modifyDate = modifiedDate;
    }
}
