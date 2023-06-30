package com.boardapp.boardapi.board.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {
    private Long boardId;

    @Builder
    public Board(Long id) {
        this.boardId = id;
    }
}
