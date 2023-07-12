package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.board.model.BoardDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public BoardDto toDto(){
        return BoardDto.builder()
                                .num(this.boardId)
                                .title(this.boardTitle)
                                .contents(this.boardContents)
                                .writeName(this.writeId)
                                .modifyName(this.modifyId)
                                .writeDate(this.writeDate)
                                .modifyDate(this.modifyDate)
                                .build();
    }
}