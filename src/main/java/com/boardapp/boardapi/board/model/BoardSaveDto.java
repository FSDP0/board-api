package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BoardSaveDto {
    private String title;
    private String contents;

    private String writer;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).contents(this.contents).writeId(this.writer)
                .writeDate(Timestamp.valueOf(LocalDateTime.now())).build();

        return board;
    }
}
