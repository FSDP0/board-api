package com.boardapp.boardapi.board.handler;

import java.util.logging.Level;
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
import com.boardapp.boardapi.board.model.BoardReponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class BoardHandler {
    // ! Dependency injection
    private final BoardRepository boardRepository;

    // * 전체 게시글 조회 Handler
    public Mono<ServerResponse> getAllBoards(ServerRequest req) {
        log.info("[ Handler ] Request find all boards");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(Flux.fromIterable(this.boardRepository.findAll()).map(board -> board.toDto(board)), BoardReponseDto.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    // * 특정 게시글 조회 Handler
    public Mono<ServerResponse> getByBoardId(ServerRequest req) {
        log.info("[ Handler ] Request find board by boardId");

        // * [ Convert variable type ] String to Long
        Long boardId = Long.parseLong(req.pathVariable("id"));

        log.info("[ Handler ] Received parameter : " + boardId);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(Mono.fromCallable(() -> this.boardRepository.findById(boardId).get()).map(board -> board.toDto(board)),
                        BoardReponseDto.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    // * 게시글 등록 Handler
    @Transactional
    public Mono<ServerResponse> saveBoard(ServerRequest req) {
        log.info("[ Handler ] Request save board");

        return Mono.empty();

        // return boardDtoMono.flatMap(boardDto -> Mono.fromCallable(() -> this.boardRepository.save(boardDto.toEntity())))
        //         .flatMap(board -> ServerResponse.ok() // HTTP Status Code 200
        //                 .contentType(MediaType.APPLICATION_JSON) // Content Type
        //                 .bodyValue(board) // Response Body
        //         );
    }

    // * 특정 게시글 수정 Hadler
    @Transactional
    public Mono<ServerResponse> updateBoard(ServerRequest req) {
        log.info("[ Handler ] Request update board");

        Long id = Long.parseLong(req.pathVariable("id")); // * 게시글 번호

        // log.info("[ Handler ] Receivev parameter : " + id);

        // Mono<BoardEditDto> boardDtoMono = req.bodyToMono(BoardEditDto.class); // * Update Data

        // return boardDtoMono
        // .flatMap(boardDto -> Mono.fromCallable(() ->
        // this.boardRepository.updateBoard(boardDto.getTitle(), boardDto.getContents(),
        // boardDto.getModifyName(), Timestamp.valueOf(LocalDateTime.now()), id)))
        // .flatMap(data ->
        // ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build(Mono.empty()));

        Mono<BoardEditDto> boardDtoMono = req.bodyToMono(BoardEditDto.class);

        // Mono.fromCallable(()->boardDtoMono.map(dto ->
        // this.boardRepository.save(dto.toEntity(id))).map(board -> ServerResponse.ok().build()));

        // return ServerResponse.noContent()
        // .build(Mono.fromRunnable(() -> boardDtoMono.map(dto ->
        // this.boardRepository.save(dto.toEntity(id)))))
        // .log("[ Reactor ] Update board data",Level.INFO)
        // .switchIfEmpty(ServerResponse.notFound().build()); // Reponse HTTP status code 404 with empty
        // body

        // Mono.fromRunnable(() -> boardDtoMono.map(dto -> this.boardRepository.save(dto.toEntity(id))));

        Mono<Board> boardMono = req.bodyToMono(BoardEditDto.class).map(dto -> dto.toEntity(id));

        return ServerResponse.ok().build();
    }

    // ! Delete board handler
    @Transactional
    public Mono<ServerResponse> deleteBoard(ServerRequest req) {
        Long boardId = Long.parseLong(req.pathVariable("id"));

        return ServerResponse.status(HttpStatus.NO_CONTENT) // HTTP Status Code 204
                .build(Mono.from(Mono.fromRunnable(() -> this.boardRepository.deleteById(boardId)))) // Publisher required empty emit after
                                                                                                     // onComplete [ Mono<Void> ]
                .log("[ Reactor ] Delete board data", Level.INFO)
                .doOnError(error -> log.error("[ Reactor ] Error occured when delete board data"))
                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404, IfEmpty
    }
}
