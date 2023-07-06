package com.boardapp.boardapi.board.service;

import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
}
