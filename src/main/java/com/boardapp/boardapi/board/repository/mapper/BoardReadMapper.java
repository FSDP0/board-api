package com.boardapp.boardapi.board.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.board.model.Board;

public interface BoardReadMapper {
    List<Board> getAllBoards() throws Exception;

    Board getByBoardId(@Param("id") Long id) throws Exception;
}
