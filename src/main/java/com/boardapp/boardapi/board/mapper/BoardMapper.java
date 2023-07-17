package com.boardapp.boardapi.board.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.board.model.Board;

@Mapper
public interface BoardMapper {
    List<Board> findAllBoards();

    Board findByBoardId(@Param("boardId") Long boardId);

    Integer saveBoard(@Param("boardObj") Board board);

    Integer updateBoard(@Param("boardObj") Board board);

    Integer deleteBoard(@Param("boardId") Long boardId);
}
