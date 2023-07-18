package com.boardapp.boardapi.board.repository;

import com.boardapp.boardapi.board.entity.Board;

public interface BoardCustomRepository {
    Integer updateBoard(Board board);
}
