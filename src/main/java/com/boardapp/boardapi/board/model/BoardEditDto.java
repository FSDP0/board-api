package com.boardapp.boardapi.board.model;

import com.boardapp.boardapi.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardEditDto {
    private String title;
    private String contents;

    private String editId;
    private String editName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).editorId(this.editId)
                .editorName(this.editName).contents(this.contents).build();

        return board;
    }

    @Builder
    public BoardEditDto(String title, String contents, String editId, String editName) {
        this.title = title;
        this.contents = contents;

        this.editId = editId;
        this.editName = editName;
    }
}
