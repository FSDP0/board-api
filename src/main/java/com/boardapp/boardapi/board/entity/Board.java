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

    @Column(name = "board_creator_id", length = 50, nullable = false)
    private String boardCreatorId;

    @Column(name = "board_creator_name", length = 50, nullable = false)
    private String boardCreatorName;

    @Column(name = "board_contents", length = 200, nullable = true)
    private String boardContents;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "board_editor_id", length = 50, nullable = true)
    private String boardEditorId;

    @Column(name = "board_editor_name", length = 50, nullable = true)
    private String boardEditorName;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, String creatorId, String creatorName, String editorId,
            String editorName, String contents, Date createdDate, Date modifiedDate) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.boardCreatorId = creatorId;
        this.boardCreatorName = creatorName;

        this.boardEditorId = editorId;
        this.boardEditorName = editorName;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
