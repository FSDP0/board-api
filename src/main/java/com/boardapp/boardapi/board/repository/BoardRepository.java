package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.repository.sql.BoardJPQL;
import jakarta.transaction.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = BoardJPQL.SELECT_ALL)
    public List<Board> selectAllBoard();

    @Query(value = BoardJPQL.SELECT_BY_ID)
    public Board selectBoardById(@Param("id") Long id);

    // 객체를 파라미터로 전달
    @Modifying
    @Transactional
    @Query(value = BoardJPQL.INSERT_BOARD)
    public void saveBoard(@Param("boardObj") Board board);

    // 객체를 파라미터로 전달
    @Modifying
    @Query(value = BoardJPQL.UPDATE_BY_ID)
    public void updateBoard(@Param("boardObj") Board board, @Param("id") Long id);

    @Modifying
    @Query(value = BoardJPQL.DELETE_BY_ID)
    public void deleteBoard(@Param("id") Long id);
}
