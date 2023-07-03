package com.boardapp.boardapi.board.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.service.BoardService;
import reactor.core.publisher.Mono;

@Component
public class BoardHandler {
    // ! Service dependency injection
    private final BoardService boardService;

    public BoardHandler(BoardService boardService) {
        this.boardService = boardService;
    }
    // !

    // ! Hanlder for find all
    public Mono<ServerResponse> getAllBoards(ServerRequest req) {
        return ServerResponse.ok() // HTTP Status Code 200
                .contentType(MediaType.APPLICATION_JSON) // Content-Type : Application/json
                .body(this.boardService.getAllBoard(), Board.class); // Response Body
    }

    //
    public Mono<ServerResponse> getBoardById(ServerRequest req) {
        return this.boardService.getBoardById(Long.parseLong(req.pathVariable("id")))
                .flatMap(board -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(board, Board.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> saveBoard(ServerRequest req) {
        Mono<BoardSaveDto> boardDto = req.bodyToMono(BoardSaveDto.class);

        return boardDto.flatMap(b -> ServerResponse.status(HttpStatusCode.valueOf(204)).contentType(MediaType.APPLICATION_JSON)
                .body(this.boardService.createBoard(b), BoardSaveDto.class));
    }

    public Mono<ServerResponse> updateBoard(ServerRequest req) {
        Long id = Long.parseLong(req.pathVariable("id"));
        Mono<BoardEditDto> updateBoard = req.bodyToMono(BoardEditDto.class);

        return updateBoard.flatMap(b -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(this.boardService.updateBoard(id, b), BoardEditDto.class));
    }

    public Mono<ServerResponse> deleteBoard(ServerRequest req) {
        return this.boardService.deleteBoard(Long.parseLong(req.pathVariable("id"))).flatMap(b -> ServerResponse.ok().body(b, Board.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
