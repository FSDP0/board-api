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
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    private List<Board> findAllBoards() {
        return this.boardService.findAllBoards();
    }

    @GetMapping("/:{boardId}")
    private Board findByBoardId(@PathVariable Long boardId) {
        return this.boardService.findByBoardId(boardId);
    }

    @PostMapping
    private String saveBoard(@RequestBody Board dto) {
        return "Effected Row : " + this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{boardId}")
    private String updateBoard(@PathVariable Long boardId, @RequestBody Board dto) {
        return "Effected Row : " + this.boardService.updateBoard(boardId, dto);
    }

    @DeleteMapping("/:{boardId}")
    private String deleteBoard(@PathVariable Long boardId) {
        return "Effected Row : " + this.boardService.deleteBoard(boardId);
    }
}
