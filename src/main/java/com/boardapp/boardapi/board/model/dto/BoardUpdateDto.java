package com.boardapp.boardapi.board.model.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.board.model.Board;
import lombok.Getter;

@Getter
public class BoardUpdateDto {
    private String title;
    private String contents;

    private String modifyName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).contents(this.contents).modifyId(this.modifyName)
                .modifyDate(Timestamp.valueOf(LocalDateTime.now())).build();

        return board;
    }
}
