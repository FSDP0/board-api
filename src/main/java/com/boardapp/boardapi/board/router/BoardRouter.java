package com.boardapp.boardapi.board.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.board.handler.BoardHandler;

@Configuration
public class BoardRouter {
	// ! Handler dependency injection
	private final BoardHandler boardHandler;

	public BoardRouter(BoardHandler boardHandler) {
		this.boardHandler = boardHandler;
	}
	// !

	// ! Board routes configuration Bean
	@Bean
	RouterFunction<ServerResponse> routes() {
		// ! RouterFunction은 작성된 코드에 근거하여 순차적으로 실행된다. 따라서, 세부적인 검색 조건이 있는 Route Path를 먼저 배치해야한다.
		// return RouterFunctions
		// .route(RequestPredicates.GET("/boardsee/:{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
		// boardHandler::getByBoardId) // * 특정 게시글 번호로 조회
		// .andRoute(RequestPredicates.GET("/boardsee").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
		// boardHandler::getAllBoards) // * 모든 게시글 조회
		// .andRoute(RequestPredicates.POST("/boardsee").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
		// boardHandler::saveBoard); // * 게시글 등록
		// .andRoute(RequestPredicates.PUT("/boards/:{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
		// boardHandler::updateBoard) // * 특정 게시글 수정
		// .andRoute(RequestPredicates.DELETE("/boards/:{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
		// boardHandler::deleteBoard); // * 특정 게시글 삭제

		// return RouterFunctions.nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), );
		return RouterFunctions.nest(RequestPredicates.accept(MediaType.APPLICATION_JSON),
				routes(RequestPredicates.GET("/boards"), this.boardHandler.getAllBoards(null)));
	}
	// !
}
