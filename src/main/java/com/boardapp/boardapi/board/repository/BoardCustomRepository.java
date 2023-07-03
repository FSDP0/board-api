package com.boardapp.boardapi.board.repository;

import com.boardapp.boardapi.board.entity.Board;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardCustomRepository {
    Flux<Board> findAllBoardsByWriteId(String userId);

    Flux<Board> findAllBoardsByModifyId(String userId);

    Mono<Board> findBoardByWriteId(String userId);

    Mono<Board> findBoardByModifyId(String userId);
}
