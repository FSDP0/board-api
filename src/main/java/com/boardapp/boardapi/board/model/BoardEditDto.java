package com.boardapp.boardapi.board.model;

import lombok.Getter;

@Getter
public class BoardEditDto {
    private String title;
    private String contents;

    private String editId;
    private String editName;
}
