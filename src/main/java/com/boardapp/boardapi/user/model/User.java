package com.boardapp.boardapi.user.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private Long userId;

    @Builder
    public User(Long id) {
        this.userId = id;
    }
}
