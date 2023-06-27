package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardEditDto {
    private String title;
    private String contents;

    private String editId;
    private String editName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).contents(this.contents)
                .editorId(this.editId).editorName(this.editName)
                .modifiedDate(Timestamp.valueOf(LocalDateTime.now())).build();

        return board;
    }
}
