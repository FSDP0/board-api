package com.boardapp.boardapi.user.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.model.UserDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public Flux<UserDto> getAllUser(){
        return Flux.fromIterable(this.userRepository.findAll())
                    .map(user -> user.toDto());
    }

    @Override
    public Mono<UserDto> getByUserId(String userId) {
        return Mono.fromCallable(() -> this.userRepository.findById(userId).get())
                    .map(user -> user.toDto());
    }

    @Override
    public Mono<UserDto> createUser(Mono<UserDto> dtoMono) {
        return dtoMono.map(userDto -> this.userRepository.saveAndFlush(userDto.toUserEntity()))
                        .map(data -> data.toDto());
    }

    @Override
    @Transactional
    public Mono<Integer> editUser(String userId, Mono<UserDto> dtoMono) {
        return dtoMono.map(userDto -> this.userRepository.updateUser(userDto.toUserEntity(userId)));
    }

    @Override
    @Transactional
    public Mono<Void> removeUser(String userId) {
        return Mono.fromRunnable(() -> this.userRepository.deleteById(userId));
    }
}
