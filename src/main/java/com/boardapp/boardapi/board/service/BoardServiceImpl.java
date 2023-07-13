package com.boardapp.boardapi.board.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardrepository;

    @Override
    public Flux<BoardDto> getAllBoards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBoards'");
    }

    @Override
    public Mono<BoardDto> getByBoardId(Long boardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByBoardId'");
    }

    @Override
    public Mono<BoardDto> createBoard(Mono<BoardDto> dtoMono) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBoard'");
    }

    @Override
    public Mono<Void> updateBoard(Long boardId, Mono<BoardDto> dtoMono) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBoard'");
    }

    @Override
    public Mono<Void> removeBoard(Long boardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeBoard'");
    }
    
}
