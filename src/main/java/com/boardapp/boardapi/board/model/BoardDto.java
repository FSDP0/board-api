package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDto {
    private Long num;

    private String title;
    private String contents;
    private String writeName;
    private String modifyName;

    private Date writeDate;
    private Date modifyDate;

    // * Convert to Save Entity
    public Board toEntity() {
        return Board.builder()
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .writeId(this.writeName)
                    .modifyId(this.modifyName)
                    .build();
    }

    // * Convert to Edit Entity
    public Board toEntity(Long boardId){
        return Board.builder()
                    .boardId(boardId)
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .writeId(this.writeName)
                    .modifyId(this.modifyName)
                    // ! Native Query do not audit modified date field
                    .modifyDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }
}
