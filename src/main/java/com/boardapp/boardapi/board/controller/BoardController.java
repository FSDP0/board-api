package com.boardapp.boardapi.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.service.BoardService;

@RestController
@RequestMapping("boards")
public class BoardController {

    private final BoardService boardService;

    private BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    private List<BoardDto> findAllBoard() {
        return this.boardService.getAllBoards();
    }

    @GetMapping("/:{id}")
    private BoardDto findBoardById(@PathVariable Long id) {
        return this.boardService.getBoardById(id);
    }

    @PostMapping
    private void saveBoard(@RequestBody BoardDto dto) {
        this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{id}")
    private void Board(@PathVariable Long id, @RequestBody BoardDto dto) {
        this.boardService.updateBoard(id, dto);
    }

    @DeleteMapping("/:{id}")
    private void deleteByBoardId(@PathVariable Long id) {
        this.boardService.deleteBoard(id);
    }
}
