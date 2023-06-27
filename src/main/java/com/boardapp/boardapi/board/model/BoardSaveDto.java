package com.boardapp.boardapi.board.model;

import com.boardapp.boardapi.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardSaveDto {
    private String title;
    private String contents;

    private String writeId;
    private String writeName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).creatorId(this.writeId)
                .creatorName(this.writeName).contents(this.contents).build();

        return board;
    }

    @Builder
    public BoardSaveDto(String title, String contents, String writeId, String writeName) {
        this.title = title;
        this.contents = contents;

        this.writeId = writeId;
        this.writeName = writeName;
    }
}
