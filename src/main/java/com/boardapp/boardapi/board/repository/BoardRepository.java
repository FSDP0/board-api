package com.boardapp.boardapi.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.repository.sql.BoardJPQL;
import jakarta.transaction.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Modifying
    @Transactional
    @Query(value = BoardJPQL.UPDATE_BY_ID)
    Integer updateBoard(@Param("boardObj") Board board);    
}
