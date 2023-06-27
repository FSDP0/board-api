package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Getter;

@Getter
public class BoardWithUserDto {
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String creatorId;
    private String creatorName;
    private String userAddress;
    private String addressZipcode;

    private String editorId;
    private String editorName;

    private Date createdDate;

    private Date modifiedDate;
}
