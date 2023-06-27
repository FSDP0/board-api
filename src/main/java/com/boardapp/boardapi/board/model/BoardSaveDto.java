package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Getter;

// Mapping with thymeleaf template variables
@Getter
public class BoardSaveDto {
    private String title;
    private String contents;

    private String writeId;
    private String writeName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).contents(this.contents)
                .creatorId(this.writeId).creatorName(this.writeName)
                .createdDate(Timestamp.valueOf(LocalDateTime.now())).build();

        return board;
    }
}
