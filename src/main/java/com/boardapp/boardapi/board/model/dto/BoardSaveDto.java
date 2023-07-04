package com.boardapp.boardapi.board.model.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.board.model.Board;
import lombok.Getter;

@Getter
public class BoardSaveDto {
    private String title;
    private String contents;

    private String writeName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).contents(this.contents).writeId(this.writeName)
                .writeDate(Timestamp.valueOf(LocalDateTime.now())).build();

        return board;
    }
}
