package com.boardapp.boardapi.board.dao;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardDao {
    List<Board> findAllBoards();

    Board findByBoardId(Long boardId);

    void saveBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Long boardId);
}
