package com.boardapp.boardapi.board.repository;

import com.boardapp.boardapi.board.model.Board;

public interface BoardCudRepository {
    void saveBoard(Board board);

    void updateBoard(Long boardId,Board board);

    void deleteBoard(Long boardId);
}
