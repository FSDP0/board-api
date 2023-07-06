package com.boardapp.boardapi.user.service;

import com.boardapp.boardapi.user.model.UserEditDto;
import com.boardapp.boardapi.user.model.UserResonseDto;
import com.boardapp.boardapi.user.model.UserSaveDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserResonseDto> getAllUser();

    Mono<UserResonseDto> getByUserId(String userId);

    Mono<Void> saveUser(Mono<UserSaveDto> dtoMono);

    Mono<Void> updateUser(String userId, Mono<UserEditDto> dtoMono);

    Mono<Void> deleteUser(String userId);
}
