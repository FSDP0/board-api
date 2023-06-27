package com.boardapp.boardapi.board.model;

import java.util.Date;

public interface BoardUserDto {
    // Board Id
    Long getNum();

    // Board Title
    String getTitle();

    // Board Contents
    String getContents();

    // Board Writer Info //
    String getWriterId();

    String getWriter();

    String getWriterTel();

    String getWriterAddress();

    String getWriterAddressZipcode();
    //

    // Board Editor Info //
    String getEditorId();

    String getEditor();

    String getEditorTel();

    String getEditorAddress();

    String getEditorAddressZipcode();
    //

    // Board WriteDate
    Date getWriteDate();

    // Board ModifyDate
    Date getModifyDate();
}
