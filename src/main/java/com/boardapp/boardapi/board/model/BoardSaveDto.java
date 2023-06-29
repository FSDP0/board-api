package com.boardapp.boardapi.board.model;

import com.boardapp.boardapi.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardSaveDto {
    private String title;
    private String contents;

    private String writeId;
    private String writeName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title) // 게시글 제목
                .contents(this.contents) // 게시글 내용
                .creator(this.writeId).build();

        return board;
    }
}
