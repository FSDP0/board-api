package com.boardapp.boardapi.user.service;

import com.boardapp.boardapi.user.model.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserDto> getAllUser();

    Mono<UserDto> getByUserId(String userId);

    Mono<UserDto> createUser(Mono<UserDto> userDtoMono);

    Mono<UserDto> editUser(String userId, Mono<UserDto> userDtoMono);

    Mono<Void> removeUser(String userId);
}
