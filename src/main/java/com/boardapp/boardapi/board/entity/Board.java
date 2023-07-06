package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table("board")
public class Board {
    @Id
    @Column("id")
    private Long id;

    @Column("board_title")
    private String boardTitle;

    @Column("board_contents")
    private String boardContents;

    @Column("write_id")
    private String writeId;

    @Column("modify_id")
    private String modifyId;

    @Column("write_date")
    private Date writeDate;

    @Column("modify_date")
    private Date modifyDate;
}
