package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.board.model.BoardReponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "board") // * Table Name
public class Board {
    @Id
    @Column("board_id")
    private Long boardId; // ! 게시글 번호 [PK]

    @Column("board_title")
    private String boardTitle; // ! 게시글 제목

    @Column("board_contents")
    private String boardContents; // ! 게시글 내용

    @Column("write_id")
    private String writeId; // ! 게시글 작성자 Id

    @Column("modify_id")
    private String modifyId; // ! 게시글 수정자 Id

    @Column("write_date")
    @CreatedDate
    private Date writeDate; // ! 게시글 작성일

    @Column("modify_date")
    @LastModifiedDate
    private Date modifyDate; // ! 게시글 수정일

    public BoardReponseDto toDto(Board board){
        return BoardReponseDto.builder()
                                .id(this.boardId)
                                .title(this.boardTitle)
                                .contents(this.boardContents)
                                .writeId(this.writeId)
                                .modifyId(this.modifyId)
                                .writeDate(this.writeDate)
                                .modifyDate(this.modifyDate)
                                .build();
    }

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
