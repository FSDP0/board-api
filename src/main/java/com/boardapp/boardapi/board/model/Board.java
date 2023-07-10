package com.boardapp.boardapi.board.model;

import java.util.Date;
import com.boardapp.boardapi.board.model.dto.BoardDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {
    private Long boardId; // PK

    private String boardTitle;
    private String boardContents;

    private String writeId; // Join Key
    private String modifyId; // Join Key

    private Date writeDate;
    private Date modifyDate;

    public BoardDto toDto(){
        return BoardDto.builder()
                        .num(this.boardId)
                        .title(this.boardTitle)
                        .contents(this.boardContents)
                        .writeName(this.writeId)
                        .modifyName(this.modifyId)
                        .writeDate(this.writeDate)
                        .modifyDate(this.modifyDate)
                        .build();
    }

    @Builder
    public Board(Long id, String title, String contents, String writeId, String modifyId, Date writeDate, Date modifyDate) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.writeId = writeId;
        this.modifyId = modifyId;

        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}
