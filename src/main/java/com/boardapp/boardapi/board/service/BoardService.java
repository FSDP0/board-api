package com.boardapp.boardapi.board.service;

import java.util.List;
import com.boardapp.boardapi.board.model.dto.BoardDto;

public interface BoardService {

    List<BoardDto> getAllBoards();

    BoardDto getByBoardId(Long boardId);

    void saveBoard(BoardDto boardDto);

    void updateBoard(Long boardId, BoardDto boardDto);

    void deleteBoard(Long boardId);
}
