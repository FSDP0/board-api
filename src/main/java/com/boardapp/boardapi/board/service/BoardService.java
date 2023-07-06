package com.boardapp.boardapi.board.service;

import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardReponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardService{
    Flux<BoardReponseDto> getAllBoards();

    Mono<BoardReponseDto> getByBoardId(Long id);

    Mono<Void> saveBoard(Mono<BoardSaveDto> dtoMono);

    Mono<Void> updateBoard(Long id,Mono<BoardEditDto> dtoMono);

    Mono<Void> deleteBoard(Long id);
}
