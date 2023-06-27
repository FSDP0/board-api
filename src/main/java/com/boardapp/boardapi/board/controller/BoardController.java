package com.boardapp.boardapi.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.service.BoardService;

@RestController
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;

    private BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    private List<BoardResponseDto> findAllBoard() {
        return this.boardService.getAllBoard();
    }

    @GetMapping("/:{id}")
    private BoardResponseDto findBoardById(@PathVariable Long id) {
        return this.boardService.getBoardById(id);
    }

    @PostMapping
    private void saveBoard(@RequestBody BoardSaveDto dto) {
        this.boardService.createBoard(dto);
    }

    @PutMapping("/:{id}")
    private void Board(@PathVariable Long id, @RequestBody BoardEditDto dto) {}

    @DeleteMapping("/:{id}")
    private void deleteByBoardId(@PathVariable Long id) {
        this.boardService.removeBoard(id);
    }
}
