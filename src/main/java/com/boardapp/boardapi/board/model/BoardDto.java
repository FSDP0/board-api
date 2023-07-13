package com.boardapp.boardapi.board.model;

import java.util.Date;
import com.boardapp.boardapi.board.entity.Board;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {
    private Long num;

    private String title;
    private String contents;

    private String writeId;
    private String writeName;
    private String writeTel;

    private String modifyId;
    private String modifyName;
    private String modifyTel;

    private Date writeDate;
    private Date modifyDate;

    // * Convert DTO to Save Entity
    public Board toEntity(){
        return Board.builder()
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .creatorId(this.writeId)
                    .build();
    }

    // * Convert DTO to Update Entity
    public Board toEntity(Long boardId){
        return Board.builder()
                    .boardId(boardId) // ! This id field must be required
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .editorId(this.modifyId)
                    .build();
    }
}
