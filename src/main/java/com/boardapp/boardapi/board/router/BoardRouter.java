package com.boardapp.boardapi.board.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.board.handler.BoardHandler;

// ! WebFlux routes configuration class
@Configuration
public class BoardRouter {
    // ! Handler dependency injection
    private final BoardHandler boardHandler;

    public BoardRouter(BoardHandler boardHandler) {
        this.boardHandler = boardHandler;
    }
    // !

    // ! Routes Bean
    @Bean
    RouterFunction<ServerResponse> routes() {
        return RouterFunctions
                .route(RequestPredicates.GET("/boards").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        boardHandler::getAllBoards) // * 모든 게시글 조회
                .andRoute(RequestPredicates.GET("/boards/:{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        boardHandler::getAllBoards) // * 특정 게시글 번호로 조회
                .andRoute(RequestPredicates.POST("/boards").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        boardHandler::getAllBoards) // * 게시글 등록
                .andRoute(RequestPredicates.PUT("/boards/:{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        boardHandler::getAllBoards) // * 특정 게시글 수정
                .andRoute(RequestPredicates.DELETE("/boards/:{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        boardHandler::getAllBoards); // * 특정 게시글 삭제
    }
    // !
}
