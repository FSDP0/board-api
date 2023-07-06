package com.boardapp.boardapi.user.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
