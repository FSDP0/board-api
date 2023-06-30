package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Getter;

@Getter
public class BoardWithEditor {
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String editorId;
    private String editorName;
    private String editorTel;
    private String editorAddress;
    private String editorDetailAddress;
    private String editorAddressZipcode;

    private Date writeDate;
    private Date modifyDate;
}
