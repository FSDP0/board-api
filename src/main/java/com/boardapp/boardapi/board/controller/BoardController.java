package com.boardapp.boardapi.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.model.BoardWithUserReponseDto;
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
        return this.boardService.getAllBoards();
    }

    @GetMapping("/detail")
    private List<BoardWithUserReponseDto> findAllBoardDetail() {
        return this.boardService.getAllBoardsDetail();
    }

    @GetMapping("/:{id}")
    private BoardResponseDto findBoardById(@PathVariable Long id) {
        return this.boardService.getBoardById(id);
    }

    @GetMapping("/detail/:{id}")
    private void findBoardByIdDetail(@PathVariable Long id) {}

    @PostMapping
    private void saveBoard(@RequestBody BoardSaveDto dto) {
        this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{id}")
    private void Board(@PathVariable Long id, @RequestBody BoardEditDto dto) {
        this.boardService.updateBoard(id, dto);
    }

    @DeleteMapping("/:{id}")
    private void deleteByBoardId(@PathVariable Long id) {
        this.boardService.deleteBoard(id);
    }

}
