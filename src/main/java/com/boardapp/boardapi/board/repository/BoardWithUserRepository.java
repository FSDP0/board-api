package com.boardapp.boardapi.board.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.board.model.BoardWithUserDto;

public interface BoardWithUserRepository extends CrudRepository<BoardWithUserDto, Long> {
    @Query(value = BoardSQL.SELECT_BOARD_WITH_USER)
    public BoardWithUserDto findBoardWithUserById(@Param("id") Long id);
}
