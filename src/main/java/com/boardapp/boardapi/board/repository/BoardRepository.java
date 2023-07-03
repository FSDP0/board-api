package com.boardapp.boardapi.board.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.boardapp.boardapi.board.entity.Board;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardRepository extends ReactiveCrudRepository<Board, Long> {
    public Flux<Board> findAllBoard();

    public Mono<Board> findBoardById(Long id);

}
