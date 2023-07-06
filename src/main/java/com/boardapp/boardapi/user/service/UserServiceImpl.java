package com.boardapp.boardapi.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.boardapp.boardapi.user.model.UserEditDto;
import com.boardapp.boardapi.user.model.UserResonseDto;
import com.boardapp.boardapi.user.model.UserSaveDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    // ! Dependency injection
    private final UserRepository userRepository;

    @Override
    public Flux<UserResonseDto> getAllUser() {
        return Flux.fromIterable(this.userRepository.findAll())
                    .map(user -> user.toDto(user));
    }

    @Override
    public Mono<UserResonseDto> getByUserId(String userId) {
        return Mono.fromCallable(()->this.userRepository.findById(userId).get())
                    .map(user -> user.toDto(user));
    }

    @Override
    @Transactional
    public Mono<Void> saveUser(Mono<UserSaveDto> dtoMono) {
        return dtoMono.map(dto -> this.userRepository.saveBoard(dto.toEntity()))
                        .and(ServerResponse.ok().build());
    }

    @Override
    @Transactional
    public Mono<Void> updateUser(String userId, Mono<UserEditDto> dtoMono) {
        return dtoMono.map(dto-> this.userRepository.updateBoard(dto.toEntity(userId)))
                        .and(ServerResponse.ok().build());
    }

    @Override
    @Transactional
    public Mono<Void> deleteUser(String userId) {
        return Mono.fromRunnable(()->this.userRepository.deleteById(userId))
                    .and(ServerResponse.ok().build());
    }
}
