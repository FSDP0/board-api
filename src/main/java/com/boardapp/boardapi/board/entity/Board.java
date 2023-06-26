package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Board {
    @Id
    private Long boardId;

    private String boardTitle;
    private String writeId;
    private String writeName;
    private String boardContents;

    private Date createdDate;
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, String contents, Date createdDate, Date modifiedDate) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
