package com.boardapp.boardapi.board.model;

import com.boardapp.boardapi.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardEditDto {
    private Long num;

    private String title;

    private String editId;
    private String editName;

    private String contents;

    public Board toEntity() {
        Board board = Board.builder().build();

        return board;
    }

    @Builder
    public BoardEditDto(Long id, String title, String editorId, String editorName,
            String contents) {
        this.num = id;

        this.title = title;
        this.editId = editorId;
        this.editName = editorName;
        this.contents = contents;
    }
}
