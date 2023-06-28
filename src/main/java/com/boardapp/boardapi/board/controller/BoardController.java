package com.boardapp.boardapi.board.controller;

import org.springframework.web.bind.annotation.*;
import com.boardapp.boardapi.board.service.BoardService;

@RestController
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;

    private BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    private void findAllBoard() {}

    @GetMapping("/detail")
    private void findAllBoardDetail() {}

    @GetMapping("/:{id}")
    private void findBoardById(@PathVariable Long id) {}

    @GetMapping("/detail/:{id}")
    private void findBoardByIdDetail(@PathVariable Long id) {}

    @PostMapping
    private void saveBoard(
    // @RequestBody BoardSaveDto dto
    ) {}

    @PutMapping("/:{id}")
    private void Board(
    // @PathVariable Long id, @RequestBody BoardEditDto dto
    ) {

    }

    @DeleteMapping("/:{id}")
    private void deleteByBoardId(@PathVariable Long id) {}

    @GetMapping("/test")
    private Iterable<Object> sample() {
        return this.boardService.sample();
    }
}
