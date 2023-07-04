package com.boardapp.boardapi.board.handler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class BoardHandler {
    // ! Service dependency injection
    private final BoardRepository boardRepository;

    public BoardHandler(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    // !

    // * 전체 게시글 조회 Handler
    public Mono<ServerResponse> getAllBoards(ServerRequest req) {
        log.info("[ Handler ] Request find all boards");

        Flux<Board> boardFlux = Flux.fromIterable(this.boardRepository.findAll());

        return ServerResponse.ok()// HTTP Status Code 200 [OK]
                .contentType(MediaType.APPLICATION_JSON) // Content Type
                .body(boardFlux, Board.class) // Reponse Body
                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404, IfEmpty
    }

    // * 특정 게시글 조회 Handler
    public Mono<ServerResponse> getByBoardId(ServerRequest req) {
        log.info("[ Handler ] Request find board by boardId");

        // * [ Convert variable type ] String to Long
        Long boardId = Long.parseLong(req.pathVariable("id"));

        log.info("[ Handler ] Received parameter : " + boardId);

        Mono<Board> board = Mono.just(this.boardRepository.findById(boardId).get());

        return ServerResponse.ok() // HTTP Status Code 200 [OK]
                .contentType(MediaType.APPLICATION_JSON) // Conetent Type
                .body(board, Board.class) // Response Body
                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404, IfEmpty
    }

    // * 게시글 등록 Handler
    @Transactional
    public Mono<ServerResponse> saveBoard(ServerRequest req) {
        log.info("[ Handler ] Request save board");

        Mono<BoardSaveDto> boardDtoMono = req.bodyToMono(BoardSaveDto.class);

        return boardDtoMono.flatMap(boardDto -> Mono.fromCallable(() -> this.boardRepository.save(boardDto.toEntity())))
                .flatMap(board -> ServerResponse.ok() // HTTP Status Code 200
                        .contentType(MediaType.APPLICATION_JSON) // Content Type
                        .bodyValue(board) // Response Body
                );
    }

    // * 특정 게시글 수정 Hadler
    @Transactional
    public Mono<ServerResponse> updateBoard(ServerRequest req) {
        log.info("[ Handler ] Request update board");

        Long id = Long.parseLong(req.pathVariable("id")); // * 게시글 번호

        log.info("[ Handler ] Receivev parameter : " + id);

        Mono<BoardEditDto> boardDtoMono = req.bodyToMono(BoardEditDto.class); // * Update Data

        return boardDtoMono
                .flatMap(boardDto -> Mono.fromCallable(() -> this.boardRepository.updateBoard(boardDto.getTitle(), boardDto.getContents(),
                        boardDto.getModifyName(), Timestamp.valueOf(LocalDateTime.now()), id)))
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build(Mono.empty()));
    }

    // * 특정 게시글 삭제 Handler
    @Transactional
    public Mono<ServerResponse> deleteBoard(ServerRequest req) {

        Long boardId = Long.parseLong(req.pathVariable("id"));

        this.boardRepository.deleteById(boardId);

        return ServerResponse.status(HttpStatus.NO_CONTENT) // HTTP Status Code 204
                .build(Mono.empty()) // Publisher<Void>
                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404, IfEmpty
    }
}
