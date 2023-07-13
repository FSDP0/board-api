package com.boardapp.boardapi.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boardapp.boardapi.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
