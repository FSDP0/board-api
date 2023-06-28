package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
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

    // @Transient
    // @Column("write_id")
    // @MappedCollection(idColumn = "writer_id", keyColumn = "user_id")
    // private User writer;

    // @Transient
    // @Column("modify_id")
    // @MappedCollection(idColumn = "editor_id", keyColumn = "user_id")
    // private User editor;

    @Column("write_id")
    private String writeId;

    @Column("modify_id")
    private String modifyId;

    @CreatedDate
    private Date writeDate;

    @LastModifiedDate
    private Date modifyDate;

    @Builder
    public Board(Long id, String title, String contents) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;
    }
}
