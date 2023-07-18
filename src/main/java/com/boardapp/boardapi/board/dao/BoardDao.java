package com.boardapp.boardapi.board.dao;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardDao { 
    public List<Board> findAllBoards();

    public Board findByBoardId(Long boardId);

    public Board findByQuery(Board board);

    public Integer saveBoard(Board board);

    public Integer updateBoard(Board board);

    public Integer deleteBoard(Long boardId);
}
