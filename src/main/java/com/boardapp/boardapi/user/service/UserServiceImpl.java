package com.boardapp.boardapi.user.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public Flux<UserDto> getAllUser(){
        return Flux.fromIterable(this.userRepository.findAll())
                    .map(user -> user.toDto());
    }

    public Mono<UserDto> getByUserId(String userId) {
        return Mono.fromCallable(() -> this.userRepository.findById(userId).get())
                    .map(user -> user.toDto());
    }

    public Mono<UserDto> createUser(Mono<UserDto> dtoMono) {
        return dtoMono.map(userDto -> this.userRepository.save(userDto.toUserEntity()))
                        .map(data -> data.toDto());
    }

    public Mono<UserDto> editUser(String userId, Mono<UserDto> dtoMono) {
        return dtoMono.map(userDto -> this.userRepository.saveAndFlush(userDto.toUserEntity(userId)))
                        .map(data -> data.toDto());
    }

    public Mono<Void> removeUser(String userId) {
        return Mono.fromRunnable(() -> this.userRepository.deleteById(userId));
    }
}
