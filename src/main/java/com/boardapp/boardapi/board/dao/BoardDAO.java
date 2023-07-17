package com.boardapp.boardapi.board.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.board.model.Board;

public interface BoardDao {

    public List<Board> findAllBoards();

    public Board findByBoardId(@Param("boardId") Long boardId);

    public Integer saveBoard(@Param("boardObj") Board board);

    public Integer updateBoard(@Param("boardObj") Board board);

    public Integer deleteBoard(@Param("boardId") Long boardId);
}
