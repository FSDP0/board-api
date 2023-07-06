package com.boardapp.boardapi.board.repository;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardReadRepository {
    List<Board> findAll();

    Board findByBoardId(Long boardId);
}
