package com.boardapp.boardapi.board.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.board.entity.Board;
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

        // return ServerResponse.ok() // HTTP Status Code 200
        // .contentType(MediaType.APPLICATION_JSON) // Content-Type : Application/json
        // .body(this.boardService.getAllBoard(), Board.class); // Response Body

    }

    // * 특정 게시글 조회 Handler
    public Mono<ServerResponse> getByBoardId(ServerRequest req) {
        log.info("[ Handler ] Request find board by boardId");

        Long boardId = Long.parseLong(req.pathVariable("id")); // * [ Convert variable type ] String to Long

        log.info("[ Handler ] Received parameter : " + boardId);

        Mono<Board> board = Mono.just(this.boardRepository.findById(boardId).get());

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(board, Board.class)
                .switchIfEmpty(ServerResponse.notFound().build());

        // return this.boardService.getBoardById(Long.parseLong(req.pathVariable("id")))
        // .flatMap(board -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(board,
        // Board.class))
        // .switchIfEmpty(ServerResponse.notFound().build());
    }

    // * 게시글 등록 Handler
    public Mono<ServerResponse> saveBoard(ServerRequest req) {
        log.info("[ Handler ] Request save board");

        Mono<BoardSaveDto> boardDto = req.bodyToMono(BoardSaveDto.class);

        return boardDto.flatMap(b -> ServerResponse // Server Reponse ChainMethods
                .status(HttpStatusCode.valueOf(204)) // Response HTTP Status Code 204
                .contentType(MediaType.APPLICATION_JSON) // Response Content Type
                .body(this.boardRepository.save(b.toEntity()), BoardSaveDto.class) // Reponse Body
        );
    }

    // * 특정 게시글 수정 Hadler
    // public Mono<ServerResponse> updateBoard(ServerRequest req) {
    // Long id = Long.parseLong(req.pathVariable("id")); // * 게시글 번호
    // Mono<BoardEditDto> updateBoard = req.bodyToMono(BoardEditDto.class); // * Update Data

    // return updateBoard.flatMap(b -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
    // .body(this.boardService.updateBoard(id, b), BoardEditDto.class));
    // }

    // // ! 특정 게시글 삭제 Handler
    // public Mono<ServerResponse> deleteBoard(ServerRequest req) {
    // return this.boardService.deleteBoard(Long.parseLong(req.pathVariable("id"))).flatMap(b ->
    // ServerResponse.ok().body(b, Board.class))
    // .switchIfEmpty(ServerResponse.notFound().build());
    // }
}
