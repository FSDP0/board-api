package com.boardapp.boardapi.board.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.board.model.Board;

public interface BoardReadMapper {
    List<Board> getAllBoards();

    Board getByBoardId(@Param("boardId") Long boardId);
}
