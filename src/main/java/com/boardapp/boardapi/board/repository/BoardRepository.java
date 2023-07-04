package com.boardapp.boardapi.board.repository;

import java.util.Date;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSql;

public interface BoardRepository extends CrudRepository<Board, Long>, BoardCustomRepository {
    @Modifying
    @Query(value = BoardSql.UPDATE_BY_ID)
    public Board update(@Param("title") String title, @Param("contents") String contents, @Param("modifyId") String modifyId,
            @Param("modifyDate") Date modifyDate, @Param("id") Long id);
}
