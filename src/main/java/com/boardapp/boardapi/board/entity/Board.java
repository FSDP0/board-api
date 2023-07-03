package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "board") // * Table Name
public class Board {
    @Id
    private Long boardId; // ! 게시글 번호 [PK]

    private String boardTitle; // ! 게시글 제목
    private String boardContents; // ! 게시글 내용

    private String writeId; // ! 게시글 작성자 Id
    private String modifyId; // ! 게시글 수정자 Id

    private Date writeDate; // ! 게시글 작성일
    private Date modifyDate; // ! 게시글 수정일

    @Builder
    public Board(Long id, String title, String contents, String writeId, String modifyId, Date writeDate, Date modifyDate) {
        this.boardId = id;
        this.boardTitle = title;
        this.boardContents = contents;

        this.writeId = writeId;
        this.modifyId = modifyId;

        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}
