package com.boardapp.boardapi.board.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDto {
    private Long num;
    
    private String title;
    private String contents;

    private String writeId;
    private String modifyId;

    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;

    // * Convert DTO to save entity
    public Board toEntity(){
        return Board.builder()
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .writeId(this.writeId)
                    .writeDate(LocalDateTime.now())
                    .build();
    }

    // * Convert DTO to update entity
    public Board toEntity(Long boardId){
        return Board.builder()
                    .boardId(boardId)
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .modifyId(this.modifyId)
                    .modifyDate(LocalDateTime.now())
                    .build();
    }
}
