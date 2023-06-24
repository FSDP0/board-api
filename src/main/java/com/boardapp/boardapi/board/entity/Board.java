package com.boardapp.boardapi.board.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Board {
    private Long boardId;

    private String boardTitle;
    private String userId;
    private String boardContents;

    private Date createdDate;
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, String author, String contents, Date createdDate,
            Date modifiedDate) {
        this.boardId = id;

        this.boardTitle = title;
        this.userId = author;
        this.boardContents = contents;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
