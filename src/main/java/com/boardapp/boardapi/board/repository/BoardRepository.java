package com.boardapp.boardapi.board.repository;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface BoardRepository extends BoardReadRepository, BoardCudRepository {
    // ! Basic board crud interface methods
    List<Board> findAll();

    Board findByBoardId(Long boardId);

    void saveBoard(Board board);

    void updateBoard(Long boardId, Board board);

    void deleteBoard(Long boardId);
    // !
}
