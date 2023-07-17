package com.boardapp.boardapi.board.dao;

import com.boardapp.boardapi.board.model.Board;

public interface BoardCudDao {
    Integer saveBoard(Board board);

    Integer updateBoard(Board board);

    Integer deleteBoard(Long boardId);
}
