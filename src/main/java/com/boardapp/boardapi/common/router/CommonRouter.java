// package com.boardapp.boardapi.common.router;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.MediaType;
// import org.springframework.web.reactive.function.server.RequestPredicates;
// import org.springframework.web.reactive.function.server.RouterFunction;
// import org.springframework.web.reactive.function.server.ServerResponse;
// import com.boardapp.boardapi.board.handler.BoardHandler;

// @Configuration
// public class CommonRouter {
// private final BoardHandler boardHandler;

// public CommonRouter(BoardHandler boardHandler) {
// this.boardHandler = boardHandler;
// }

// @Bean
// RouterFunction<ServerResponse> routes() {
// return
// RequestPredicates.path("/boards").nest(RequestPredicates.accept(MediaType.APPLICATION_JSON));
// }
// }
