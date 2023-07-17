package com.boardapp.boardapi.board.service;

import java.util.List;
import com.boardapp.boardapi.board.model.BoardDto;

public interface BoardService {
    List<BoardDto> findAllBoards();

    BoardDto findByBoardId(Long boardId);

    Integer saveBoard(BoardDto dto);

    Integer updateBoard(Long boardId, BoardDto dto);

    Integer deleteBoard(Long boardId);
}
