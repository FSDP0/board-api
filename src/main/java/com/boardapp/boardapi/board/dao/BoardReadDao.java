package com.boardapp.boardapi.board.dao;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardReadDao {
    List<Board> findAllBoards();

    Board findByBoardId(Long boardId);
}
