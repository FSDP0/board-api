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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    private List<BoardDto> findAllBoard() {
        return this.boardService.getAllBoards();
    }

    @GetMapping("/:{id}")
    private BoardDto findBoardById(@PathVariable Long id) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + id);

        return this.boardService.getBoardById(id);
    }

    @PostMapping
    private void createBoard(@RequestBody BoardDto boardDto) {
        this.boardService.createBoard(boardDto);
    }

    @PutMapping("/:{id}")
    private void editBoard(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + id);

        this.boardService.modifyBoard(id, boardDto);
    }

    @DeleteMapping("/:{id}")
    private void deleteBoard(@PathVariable Long id) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + id);

        this.boardService.removeBoard(id);
    }
}
