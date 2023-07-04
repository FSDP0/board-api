package com.boardapp.boardapi.user.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.user.Handler.UserHandler;

@Configuration
public class UserRouterConfig {
    private final UserHandler userHandler;

    public UserRouterConfig(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    // ! User routes configuration Bean
    @Bean
    RouterFunction<ServerResponse> userRoutes() {
        // ! RouterFunction은 작성된 코드에 근거하여 순차적으로 실행되므로, 세부적인 검색 조건이 있는 Route Path를 먼저 배치한다.
        return RouterFunctions.nest(RequestPredicates.path("/users"), // Base route path
                RouterFunctions.nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), // Basic Content-Type
                        RouterFunctions.route(RequestPredicates.GET("/:{userId}"), this.userHandler::getByUserId)
                                .andRoute(RequestPredicates.PUT("/:{userId}"), this.userHandler::updateUser)
                                .andRoute(RequestPredicates.DELETE("/:{userId}"), this.userHandler::deleteUser)
                                .andRoute(RequestPredicates.method(HttpMethod.GET), this.userHandler::getAllUser)
                                .andRoute(RequestPredicates.method(HttpMethod.POST), this.userHandler::saveUser)));
    }
    // !
}
