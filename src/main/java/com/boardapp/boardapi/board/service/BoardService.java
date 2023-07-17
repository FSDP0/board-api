package com.boardapp.boardapi.board.service;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardService {
    List<Board> findAllBoards();

    Board findByBoardId(Long boardId);

    Integer saveBoard(Board dto);

    Integer updateBoard(Long boardId, Board dto);

    Integer deleteBoard(Long boardId);
}
