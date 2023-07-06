package com.boardapp.boardapi.user.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.model.UserEditDto;
import com.boardapp.boardapi.user.model.UserSaveDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {
    // ! Service dependency injection
    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // !

    public Mono<ServerResponse> getAllUser(ServerRequest req) {
        Flux<User> userFlux = Flux.fromIterable(this.userRepository.findAll());

        return ServerResponse.ok() // HTTP Status Code 200 [OK]
                .contentType(MediaType.APPLICATION_JSON) // Response Content Type
                .body(userFlux, User.class) // Response Body
                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404
    }

    public Mono<ServerResponse> getByUserId(ServerRequest req) {
        String userId = req.pathVariable("userId");

        Mono<User> user = Mono.just(this.userRepository.findById(userId).get());

        return ServerResponse.ok() // HTTP Status Code 200 [OK]
                .contentType(MediaType.APPLICATION_JSON) // Response Content Type
                .body(user, User.class) // Response Body
                .switchIfEmpty(ServerResponse.notFound().build());

    }

    @Transactional
    public Mono<ServerResponse> saveUser(ServerRequest req) {

        Mono<UserSaveDto> userDtoMono = req.bodyToMono(UserSaveDto.class);

        return userDtoMono.flatMap(userDto -> Mono.fromCallable(() -> this.userRepository.saveBoard(userDto.toEntity())))
                .flatMap(data -> ServerResponse.ok() // HTTP Status Code 200 [OK]
                        .contentType(MediaType.APPLICATION_JSON) // Response Content Type
                        .bodyValue("Effected Row : " + data) // Response Body
                );
    }

    @Transactional
    public Mono<ServerResponse> updateUser(ServerRequest req) {
        String userId = req.pathVariable("userId");

        Mono<UserEditDto> userDtoMono = req.bodyToMono(UserEditDto.class);

        return userDtoMono.flatMap(userDto -> Mono.fromCallable(() -> this.userRepository.updateBoard(userDto.toEntity(userId))))
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue("Effected Row : " + data));
    }

    @Transactional
    public Mono<ServerResponse> deleteUser(ServerRequest req) {
        String userId = req.pathVariable("userId");

        this.userRepository.deleteById(userId);

        return ServerResponse.status(HttpStatus.NO_CONTENT) // HTTP Status Code 204
                .build(Mono.empty()) // Response Publisher<Void>
                .switchIfEmpty(ServerResponse.notFound().build()); // Response 404
    }
}
