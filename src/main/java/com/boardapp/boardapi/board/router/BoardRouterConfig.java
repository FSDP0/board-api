package com.boardapp.boardapi.board.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.board.handler.BoardHandler;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BoardRouterConfig {
    // ! Dependency Injection
    private final BoardHandler boardHandler;

    // ! Board routes configuration Bean
    @Bean
    RouterFunction<ServerResponse> boardRoutes() {
        // ! RouterFunction은 작성된 코드에 근거하여 순차적으로 실행된다. 따라서, 세부적인 검색 조건이 있는 Route Path를 먼저 배치해야한다.
        return RouterFunctions.nest(RequestPredicates.path("/boards"), // * Base route path
                RouterFunctions.nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), // * Basic Content-Type
                        RouterFunctions.route(RequestPredicates.GET("/:{id}"), this.boardHandler::getByBoardId) // * 특정 게시글 조회
                                .andRoute(RequestPredicates.PUT("/:{id}"), this.boardHandler::updateBoard) // * 특정 게시글 수정
                                .andRoute(RequestPredicates.DELETE("/:{id}"), this.boardHandler::deleteBoard) // * 특정 게시글 삭제
                                .andRoute(RequestPredicates.method(HttpMethod.GET), this.boardHandler::getAllBoards) // * 모든 게시글 조회
                                .andRoute(RequestPredicates.method(HttpMethod.POST), this.boardHandler::saveBoard) // * 게시글 등록
                ));
    }
    // !
}
