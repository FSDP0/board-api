package com.boardapp.boardapi.board.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardReponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    // ! Dependency injection
    private final BoardRepository boardRepository;

    @Override
    public Flux<BoardReponseDto> getAllBoards() {
        return Flux.fromIterable(this.boardRepository.findAll()) // * Iterable<Board> convert to Flux<Board>
                    .map(board -> board.toDto(board)); // * Mapping stream data to dto type
    }

    @Override
    public Mono<BoardReponseDto> getByBoardId(Long id) {
        return Mono.fromCallable(()->this.boardRepository.findById(id).get()) // * Board convert to Mono<Board>
                    .map(board -> board.toDto(board)); // * Mapping data to dto type
    }

    @Override
    @Transactional
    public Mono<Void> saveBoard(Mono<BoardSaveDto> boardDtoMono) {
        return boardDtoMono.map(dto -> this.boardRepository.save (dto.toEntity()))   // * Save
                            .and(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build());    // * HTTP Status Code 200 [OK] with return empty body
    }

    @Override
    @Transactional
    public Mono<Void> updateBoard(Long id, Mono<BoardEditDto> boardDtoMono) {
        return boardDtoMono.map(dto -> this.boardRepository.updateBoard(dto.toEntity(id)))  // * Update with id
                        .and(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build()); // * HTTP Status Code 200 [OK] with return empty body
    }

    @Override
    @Transactional
    public Mono<Void> deleteBoard(Long id) {
        return Mono.fromRunnable(()->this.boardRepository.deleteById(id)) // * Runnable Mono for delete by id
                    .and(ServerResponse.ok().build()); // * HTTP Status Code 200 [OK] with return empty body
    }
}
