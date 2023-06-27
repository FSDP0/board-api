package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "board")
public class Board {
    @Id
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String creatorId;
    private String creatorName;

    private String editorId;
    private String editorName;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, String contents, String creatorId, String creatorName,
            String editorId, String editorName
    // Date createdDate, Date modifiedDate
    ) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.creatorId = creatorId;
        this.creatorName = creatorName;

        this.editorId = editorId;
        this.editorName = editorName;

        // this.createdDate = createdDate;
        // this.modifiedDate = modifiedDate;
    }
}
