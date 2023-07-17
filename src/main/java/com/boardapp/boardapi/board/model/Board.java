package com.boardapp.boardapi.board.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String writeId;
    private String modifyId;

    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;
}
