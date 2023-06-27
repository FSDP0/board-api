package com.boardapp.boardapi.board.model;

import lombok.Getter;

// Mapping with thymeleaf template variables
@Getter
public class BoardSaveDto {
    private String title;

    private String writeId;

    private String contents;
}
