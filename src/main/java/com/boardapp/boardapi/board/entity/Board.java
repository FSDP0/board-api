package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.boardapp.boardapi.user.entity.User;
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

    // @Column(name = "creator_id", length = 50, nullable = false)
    // private String boardCreatorId;

    // @Column(name = "creator_name", length = 50, nullable = false)
    // private String boardCreatorName;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creatorId;

    @Column(name = "board_contents", length = 200, nullable = true)
    private String boardContents;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    // @Column(name = "editor_id", length = 50, nullable = true)
    // private String boardEditorId;

    // @Column(name = "editor_name", length = 50, nullable = true)
    // private String boardEditorName;

    @ManyToOne()
    @JoinColumn(name = "editor_id", nullable = true)
    private User editorId;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, User creatorId, User editorId, String contents,
            Date createdDate, Date modifiedDate) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.creatorId = creatorId;
        this.editorId = editorId;

        // this.boardCreatorId = creatorId;
        // this.boardCreatorName = creatorName;

        // this.boardEditorId = editorId;
        // this.boardEditorName = editorName;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
