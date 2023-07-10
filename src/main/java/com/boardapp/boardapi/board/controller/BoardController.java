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
import com.boardapp.boardapi.board.model.dto.BoardDto;
import com.boardapp.boardapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    // ! Dependency injection
    private final BoardService boardService;

    @GetMapping // * 모든 게시글 조회
    private List<BoardDto> findAllBoards() throws Exception {
        return this.boardService.getAllBoards();
    }

    @GetMapping("/:{id}") // * 특정 게시글 번호를 기준으로 게시글 조회
    private BoardDto findByBoardId(@PathVariable Long id) throws Exception {
        return this.boardService.getByBoardId(id);
    }

    @PostMapping // * 게시글 등록
    private void writeBoard(@RequestBody BoardDto dto) throws Exception {
        this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{id}") // * 특정 게시글 수정
    private void modifyBoard(@PathVariable Long id, @RequestBody BoardDto dto) throws Exception {
        this.boardService.updateBoard(id, dto);
    }

    @DeleteMapping("/:{id}") // * 특정 게시글 삭제
    private void removeBoard(@PathVariable Long id) throws Exception {
        this.boardService.deleteBoard(id);
    }
}
