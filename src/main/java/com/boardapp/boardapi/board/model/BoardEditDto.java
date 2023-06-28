package com.boardapp.boardapi.board.model;

import com.boardapp.boardapi.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardEditDto {
    private String title;
    private String contents;

    private String editId;
    private String editName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title) // 게시글 제목
                // .modifyId(this.editId) // 수정자 Id
                .contents(this.contents) // 게시글 내용
                .build();

        return board;
    }
}
