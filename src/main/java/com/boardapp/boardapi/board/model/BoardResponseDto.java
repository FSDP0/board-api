package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Matching with Tymeleaf template variables
@NoArgsConstructor
@Getter
public class BoardResponseDto {
    private Long num;

    private String title;
    private String contents;

    private String writerId;
    private String writer;

    private String editorId;
    private String editor;

    private Date writeDate;
    private Date modifyDate;

    @Builder
    public BoardResponseDto(Long id, String title, String contents, String writerId, String writer,
            String editorId, String editor, Date createdDate, Date modifiedDate) {
        this.num = id;

        this.title = title;
        this.contents = contents;

        this.writerId = writerId;
        this.writer = writer;

        this.editorId = editorId;
        this.editor = editor;

        this.writeDate = createdDate;
        this.modifyDate = modifiedDate;
    }
}
