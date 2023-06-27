package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", nullable = false)
    private Long boardId; // PK Column

    @Column(name = "board_title", length = 50, nullable = false)
    private String boardTitle;

    @Column(name = "creator_id", length = 50, nullable = false)
    private String creatorId;

    @Column(name = "creator_name", length = 50, nullable = false)
    private String creatorName;

    @Column(name = "editor_id", length = 50, nullable = true)
    private String editorId;

    @Column(name = "editor_name", length = 50, nullable = true)
    private String editorName;

    @Column(name = "board_contents", length = 200, nullable = true)
    private String boardContents;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, String creatorId, String creatorName, String editorName,
            String editorId, String contents, Date createdDate, Date modifiedDate) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.creatorId = creatorId;
        this.creatorName = creatorName;

        this.editorId = editorId;
        this.editorName = editorName;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
