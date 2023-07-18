package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.boardapp.boardapi.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long num;

    private String title;
    private String contents;

    private String writeId;
    private String modifyId;

    private Date writeDate;
    private Date modifyDate;

    // * Convert DTO to Save Entity
    public Board toEntity() {
        return Board.builder()
                    .boardId(this.num)
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .creator(this.writeId)
                    .build();
    }

    // * Convert DTO to Update Entity
    public Board toEntity(Long boardId) {
        return Board.builder()
                    .boardId(boardId)
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .editor(this.modifyId)
                    .modifyDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }
}
