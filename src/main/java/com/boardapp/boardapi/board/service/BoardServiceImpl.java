package com.boardapp.boardapi.board.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public Flux<BoardDto> getAllBoards() {
        return Flux.fromIterable(this.boardRepository.findAll()) // * Get board list date from repository
                .map(board -> board.toDto()); // * Map Convert Board to BoardDto
    }

    @Override
    public Mono<BoardDto> getByBoardId(Long boardId) {
        return Mono.fromCallable(() -> this.boardRepository.findById(boardId).get()) // * Get board data from repository
                .map(board -> board.toDto()); // * Map Convert Board to BoardDto
    }

    @Override
    @Transactional
    public Mono<BoardDto> createBoard(Mono<BoardDto> dtoMono) {
        return dtoMono.map(boardDto -> this.boardRepository.saveAndFlush(boardDto.toEntity())) // * Save entity
                        .map(data -> data.toDto()); // * Response entity data mapping
    }

    @Override
    public Mono<Integer> editBoard(Long boardId, Mono<BoardDto> dtoMono) {
        return dtoMono.map(boardDto -> this.boardRepository.updateBoard(boardDto.toEntity(boardId)));
    }

    @Override
    @Transactional
    public Mono<Void> removeBoard(Long boardId) {
        return Mono.fromRunnable(() -> this.boardRepository.deleteById(boardId));
    }
}
