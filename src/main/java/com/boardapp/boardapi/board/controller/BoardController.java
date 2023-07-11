package com.boardapp.boardapi.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    // ! Dependency injection
    private final BoardService boardService;

    @GetMapping
    private List<BoardDto> findAllBoards() {
        return this.boardService.getAllBoards();
    }

    @GetMapping("/:{id}")
    private BoardDto findByBoardId(@PathVariable Long id) {
        return this.boardService.getByBoardId(id);
    }

    @PostMapping
    private void saveBoard(@RequestBody BoardDto dto) {
        this.boardService.createBoard(dto);
    }

    @PutMapping("/:{id}")
    private void updateBoard(@PathVariable Long id, @RequestBody BoardDto dto) {
        this.boardService.editBoard(id, dto);
    }

    @DeleteMapping("/:{id}")
    private void deleteBoard(@PathVariable Long id) {
        this.boardService.removeBoard(id);
    }
}
