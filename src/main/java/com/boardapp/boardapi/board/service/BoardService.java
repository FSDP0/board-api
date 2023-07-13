package com.boardapp.boardapi.board.service;

import com.boardapp.boardapi.board.model.BoardDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardService {
    Flux<BoardDto> getAllBoards();

    Mono<BoardDto> getByBoardId(Long boardId);

    Mono<BoardDto> createBoard(Mono<BoardDto> dtoMono);

    Mono<Void> updateBoard(Long boardId, Mono<BoardDto> dtoMono);

    Mono<Void> removeBoard(Long boardId);
}
