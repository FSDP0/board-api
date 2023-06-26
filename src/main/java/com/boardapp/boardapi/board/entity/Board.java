package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.boardapp.boardapi.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", nullable = false)
    private Long boardId;

    @Column(name = "board_title", length = 50, nullable = false)
    private String boardTitle;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_creator")
    private User boardCreator;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_editor")
    private User boardEditor;

    @Column(name = "board_contents", length = 200, nullable = true)
    private String boardContents;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, String author, String contents, Date createdDate,
            Date modifiedDate) {
        this.boardId = id;
        this.boardTitle = title;
        this.boardContents = contents;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
