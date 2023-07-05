package com.boardapp.boardapi.board.mapper.slave;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.board.model.Board;

// ! SELECT
public interface SlaveDatabaseBoardMapper {
    List<Board> getAllBoards() throws Exception;

    Board getByBoardId(@Param("id") Long id) throws Exception;
}
