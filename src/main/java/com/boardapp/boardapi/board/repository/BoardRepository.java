package com.boardapp.boardapi.board.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.board.entity.Board;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board,Long>, BoardCustomRepository {

    @Cacheable(key = "all") // * Save cache with key value [ boards::all ]
    List<Board> findAll();

    @Cacheable(key="#boardId",unless = "#result == null")
    Board findByBoardId(Long boardId);

}
