package com.boardapp.boardapi.board.mapper.master;

import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.board.model.Board;

// ! INSERT / UPDATE / DELETE
public interface MasterDatabaseBoardMapper {
    void saveBoard(@Param("boardObj") Board board) throws Exception;

    void updateBoard(@Param("boardObj") Board board, @Param("id") Long id) throws Exception;

    void deleteBoard(@Param("id") Long id) throws Exception;
}
