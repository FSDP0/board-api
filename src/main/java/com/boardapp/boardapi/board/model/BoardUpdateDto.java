package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BoardUpdateDto {
    private String title;
    private String contents;

    private String modifier;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).contents(this.contents).modifyId(this.modifier)
                .modifyDate(Timestamp.valueOf(LocalDateTime.now())).build();

        return board;
    }
}
