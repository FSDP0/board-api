package com.boardapp.boardapi.board.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Board {
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String writeId;
    private String modifyId;

    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;
}
