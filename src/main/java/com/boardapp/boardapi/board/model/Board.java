package com.boardapp.boardapi.board.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String writeName;
    private String modifyName;

    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;

    // * Convert entity to dto
    public BoardDTO toDto() {
        return BoardDTO.builder()
                        .num(this.boardId)
                        .title(this.boardTitle)
                        .contents(this.boardContents)
                        .writeId(this.writeName)
                        .writeDate(this.writeDate)
                        .modifyId(this.modifyName)
                        .modifyDate(this.modifyDate)
                        .build();
    }
}
