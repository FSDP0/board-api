package com.boardapp.boardapi.board.service;

import java.util.List;
import com.boardapp.boardapi.board.model.BoardDTO;

public interface BoardService {
    List<BoardDTO> findAllBoards();

    BoardDTO findByBoardId(Long boardId);

    Integer saveBoard(BoardDTO dto);

    Integer updateBoard(Long boardId, BoardDTO dto);

    Integer deleteBoard(Long boardId);
}
