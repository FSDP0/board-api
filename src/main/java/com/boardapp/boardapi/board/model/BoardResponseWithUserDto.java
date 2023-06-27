package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Matching with Tymeleaf template variables
@NoArgsConstructor
@Getter
public class BoardResponseWithUserDto {
    private Long num;

    private String title;
    private String contents;

    private String writerId;
    private String writer;
    private String writerTel;
    private String writerAddress;
    private String writerAddressZipcode;

    private String editorId;
    private String editor;
    private String editorTel;
    private String editorAddress;
    private String editorAddressZipcode;

    private Date writeDate;
    private Date modifyDate;

    @Builder
    public BoardResponseWithUserDto(Long id, String title, String contents, String writerId,
            String writer, String writerTel, String writerAddress, String writerAddressZipcode,
            String editorId, String editor, String editorTel, String editorAddress,
            String editorAddressZipcode, Date createdDate, Date modifiedDate) {
        this.num = id;

        this.title = title;
        this.contents = contents;

        this.writerId = writerId;
        this.writer = writer;
        this.writerTel = writerTel;
        this.writerAddress = writerAddress;
        this.writerAddressZipcode = writerAddressZipcode;

        this.editorId = editorId;
        this.editor = editor;
        this.editorTel = editorTel;
        this.editorAddress = editorAddress;
        this.editorAddressZipcode = editorAddressZipcode;

        this.writeDate = createdDate;
        this.modifyDate = modifiedDate;
    }
}
