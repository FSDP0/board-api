package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

// Matching with Tymeleaf template variables
@Getter
public class BoardResponseDto {
    private Long num;

    private String title;

    private String writerId;
    private String writerName;
    private String writerTel;
    private String writerAddress;
    private String writerAddressZipcode;

    private String editorId;
    private String editorName;
    private String editorTel;
    private String editorAddress;
    private String editorAddressZipcode;

    private String contents;

    private Date writeDate;
    private Date modifyDate;

    @Builder
    public BoardResponseDto(Long id, String title, String writerId, String writerName,
            String writerTel, String writerAddress, String writerAddressZipcode, String editorId,
            String editorName, String editorTel, String editorAddress, String editorAddressZipcode,
            String contents, Date createdDate, Date modifiedDate) {
        this.num = id;

        this.title = title;
        this.contents = contents;

        this.writerId = writerId;
        this.writerName = writerName;
        this.writerTel = writerTel;
        this.writerAddress = writerAddress;
        this.writerAddressZipcode = writerAddressZipcode;

        this.editorId = editorId;
        this.editorName = editorName;
        this.editorTel = editorTel;
        this.editorAddress = editorAddress;
        this.editorAddressZipcode = editorAddressZipcode;

        this.writeDate = createdDate;
        this.modifyDate = modifiedDate;
    }
}
