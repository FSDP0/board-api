package com.boardapp.boardapi.board.model.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardWithUserResponseDto {
    private Long num;

    private String title;
    private String contents;

    private String writeId;
    private String writeName;
    private String writeTel;
    private String writeAddress;
    private String writeDetailAddress;
    private String writeAddressZipcode;

    private String modifyId;
    private String modifyName;
    private String modifyTel;
    private String modifyAddress;
    private String modifyDetailAddress;
    private String modifyAddressZipcode;

    private Date writeDate;
    private Date modifyDate;
}
