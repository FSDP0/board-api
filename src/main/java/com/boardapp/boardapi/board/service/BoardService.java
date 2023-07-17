package com.boardapp.boardapi.board.service;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardService {
    public List<Board> findAllBoards();

    public Board findByBoardId(Long boardId);

    public Integer saveBoard(Board dto);

    public Integer updateBoard(Long boardId, Board dto);

    public Integer deleteBoard(Long boardId);
}
