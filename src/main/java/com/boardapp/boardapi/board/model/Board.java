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

    private String writeId;
    private String modifyId;

    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;

    // * Convert entity to dto
    public BoardDto toDto() {
        return BoardDto.builder()
                        .num(this.boardId)
                        .title(this.boardTitle)
                        .contents(this.boardContents)
                        .writeId(this.writeId)
                        .writeDate(this.writeDate)
                        .modifyId(this.modifyId)
                        .modifyDate(this.modifyDate)
                        .build();
    }
}
