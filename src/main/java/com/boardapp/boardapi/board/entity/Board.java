package com.boardapp.boardapi.board.entity;

import java.util.Date;
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

    // FetchType : EAGER
    // 현재 Entity 조회 시에, 동시에 User Entity도 조회
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", nullable = false, insertable = false, updatable = false)
    private User creator;

    @Column(name = "creator_id", nullable = false)
    private String creatorId;

    @Column(name = "board_contents", length = 200, nullable = true)
    private String boardContents;

    // FetchType : LAZY
    // 현재 Entity 조회 중, Getter를 통해 접근 시 User Entity조회
    // N+1 문제가 발생할 수 있음 -> JPQL Fetch Join을 통해 필요시 동시에 조회로 변경 가능
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "editor_id", nullable = true, insertable = false, updatable = false)
    private User editor;

    @Column(name = "editor_id", nullable = true)
    private String editorId;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

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
