package com.boardapp.boardapi.user.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.user.Handler.UserHandler;

@Configuration
public class UserRouterConfig {
    private final UserHandler userHandler;

    public UserRouterConfig(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Bean
    RouterFunction<ServerResponse> userRoutes() {
        return RouterFunction.nest(path("/users"), nest(accept(MediaType.appli)));
    }
}
