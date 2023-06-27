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
    private String writePhoneNumber;
    private String writeAddress;
    private String writeAddressZipcode;

    private String modifyId;
    private String modifyName;
    private String modifyPhoneName;
    private String modifyAddress;
    private String modifyAddressZipcode;

    private Date writeDate;
    private Date modifyDate;

    @Builder
    public BoardResponseDto(Long num, String title, String contents, String writeId,
            String writeName, String writePhoneNumber, String writeAddress,
            String writeAddressZipcode, String modifyId, String modifyName,
            String modifyPhoneNumber, String modifyAddress, String modifyAddressZipcode,
            Date writeDate, Date modifyDate) {
        this.num = num;

        this.title = title;
        this.contents = contents;

        this.writeId = writeId;
        this.writeName = writeName;
        this.writePhoneNumber = writePhoneNumber;
        this.writeAddress = writeAddress;
        this.writeAddressZipcode = writeAddressZipcode;

        this.modifyId = modifyId;
        this.modifyName = modifyName;
        this.modifyPhoneName = modifyPhoneNumber;
        this.modifyAddress = modifyAddress;
        this.modifyAddressZipcode = modifyAddressZipcode;

        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}
