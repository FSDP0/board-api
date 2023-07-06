package com.boardapp.boardapi.board.repository;

import java.util.List;
import com.boardapp.boardapi.board.entity.Board;

public interface BoardCustomRepository {
    List<Board> findAllBoardsByWriteId(String userId);

    List<Board> findAllBoardsByModifyId(String userId);

    Board findBoardByWriteId(String userId);

    Board findBoardByModifyId(String userId);

    Integer updateBoard(Board board);
}
