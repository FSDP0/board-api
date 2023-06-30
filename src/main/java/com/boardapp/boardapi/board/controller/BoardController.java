package com.boardapp.boardapi.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.service.BoardService;

@RestController
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;

    private BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    private List<Board> findAllBoards() throws Exception {
        return this.boardService.getAllBoards();
    }
}
