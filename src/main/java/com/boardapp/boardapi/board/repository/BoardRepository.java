package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardUserDto;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // @Query(value = "SELECT A FROM Board A LEFT JOIN User B ON A.boardCreatorId = B.userId WHERE
    // A.boardCreatorId = :id")
    // BoardUserDto findByBoardIdWithUser(@Param("id") Long id);

    // @Query(value = "SELECT A.* FROM Board A LEFT JOIN User B ON A.boardCreatorId = B.userId")
    // BoardUserDto findByBoardId(@Param("id") Long id);
}
