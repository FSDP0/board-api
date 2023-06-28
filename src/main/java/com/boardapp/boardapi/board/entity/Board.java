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
import lombok.Setter;

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

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false, insertable = false, updatable = false)
    private User creator;

    @Setter
    @Column(name = "creator_id")
    private String creatorId;

    @Column(name = "board_contents", length = 200, nullable = true)
    private String boardContents;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "editor_id", nullable = true, insertable = false, updatable = false)
    private User editor;

    @Setter
    @Column(name = "editor_id")
    private String editorId;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, String creatorId, String editorId, String contents,
            Date createdDate, Date modifiedDate) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.creatorId = creatorId;
        this.editorId = editorId;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
