package com.boardapp.boardapi.board.model;

import java.util.Date;
import com.boardapp.boardapi.board.entity.Board;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BoardDto {
    private Long num;

    private String title;
    private String contents;

    private String writeName;
    private String modifyName;

    private Date createdDate;
    private Date modifiedDate;

    // * Convert DTO to Save Entity
    public Board toEntity() {
        return Board.builder()
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .writeName(this.writeName)
                    .modifyName(this.modifyName)
                    .writeDate(this.createdDate)
                    .modifyDate(this.modifiedDate)
                    .build();
    }

    // * Convert DTO to Update Entity
    public Board toEntity(Long boardId) {
        return Board.builder()
                    .boardId(boardId)
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .writeName(this.writeName)
                    .modifyName(this.modifyName)
                    .writeDate(this.createdDate)
                    .modifyDate(this.modifiedDate)
                    .build();
    }
}
