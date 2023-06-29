package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardWithUserReponseDto {
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String writeId;
    private String writeName;
    private String writePhoneNumber;
    private String writeAddress;
    private String writeAddressZipcode;

    private String modifyId;
    private String modifyName;
    private String modifyPhoneNumber;
    private String modifyAddress;
    private String modifyAddressZipcode;

    private Date writeDate;
    private Date modifyDate;

    @Builder
    public BoardWithUserReponseDto(Long id, String title, String contents, String writeId,
            String writeName, String writeTel, String writeAddress, String writeAddressZipcode,
            String modifyId, String modifyName, String modifyTel, String modifyAddress,
            String modifyAddressZipcode, Date writeDate, Date modifyDate) {
        this.boardId = id;
        this.boardTitle = title;
        this.boardContents = contents;

        this.writeId = writeId;
        this.writeName = writeName;
        this.writePhoneNumber = writeTel;
        this.writeAddress = writeAddress;
        this.writeAddressZipcode = writeAddressZipcode;

        this.modifyId = modifyId;
        this.modifyName = modifyName;
        this.modifyPhoneNumber = modifyTel;
        this.modifyAddress = modifyAddress;
        this.modifyAddressZipcode = modifyAddressZipcode;

        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}
