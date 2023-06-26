package com.boardapp.boardapi.board.model;

import java.util.Date;
import lombok.Getter;

@Getter
public class BoardDto {
    private Long num;

    private String title;
    private String wirteName;
    private String contents;

    private Date wirteDate;
    private Date modifyDate;
}
