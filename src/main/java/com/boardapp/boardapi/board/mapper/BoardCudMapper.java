package com.boardapp.boardapi.board.mapper;

import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.board.model.Board;

public interface BoardCudMapper {
    void saveBoard(@Param("boardObj") Board board);

    void updateBoard(@Param("boardObj") Board board);

    void deleteBoard(@Param("boardId") Long boardId);
}
