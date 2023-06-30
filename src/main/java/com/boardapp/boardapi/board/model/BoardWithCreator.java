package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Getter;

@Getter
public class BoardWithCreator {
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String creatorId;
    private String creatorName;
    private String creatorTel;
    private String creatorAddress;
    private String creatorDetailAddress;
    private String creatorAddressZipcode;

    private Date writeDate;
    private Date modifyDate;
}
