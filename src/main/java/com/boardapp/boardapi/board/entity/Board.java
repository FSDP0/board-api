package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import jakarta.persistence.*;

@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", nullable = false)
    private Long boardId; // PK Column

    @Column(name = "board_title", length = 50, nullable = false)
    private String boardTitle;

    @Column(name = "board_contents", length = 200, nullable = true)
    private String boardContents;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "modify_id")
    private User editor;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;
}
