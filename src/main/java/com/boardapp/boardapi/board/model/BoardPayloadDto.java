package com.boardapp.boardapi.board.model;

import java.util.Date;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardPayloadDto {
    private Long num;

    private String title;
    private String writeName;
    private String contents;

    private Date writeDate;
    private Date modifyDate;

    public Board toEntity() {
        Board board = Board.builder().id(this.num).title(this.title).author(this.writeName)
                .contents(this.contents).build();

        return board;
    }

    @Builder
    public BoardPayloadDto(Long id, String title, String writer, String contents, Date createdDate,
            Date modifiedDate) {
        this.num = id;

        this.title = title;
        this.writeName = writer;
        this.contents = contents;

        this.writeDate = createdDate;
        this.modifyDate = modifiedDate;
    }
}
