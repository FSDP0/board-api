package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@Table(name = "board")
public class Board {
    @Id
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    @Transient
    @Column("write_id")
    private User writeId;

    @Transient
    @Column("modify_id")
    private User editorId;

    @Column("write_id")
    private String creator;

    @Column("modify_id")
    private String editor;

    @CreatedDate
    private Date writeDate;

    @LastModifiedDate
    private Date modifyDate;

    @Builder
    public Board(Long id, String title, String contents, String creator, String editor) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.creator = creator;
        this.editor = editor;
    }
}
