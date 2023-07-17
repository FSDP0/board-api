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
    private final BoardService boardService;

    /**
     * 모든 게시글 조회
     * @return List<BoardDTO>
     */
    @GetMapping
    private List<BoardDto> findAllBoards() {
        return this.boardService.findAllBoards();
    }

    /**
     * 특정 게시글 조회
     * @param boardId
     * @return BoardDTO
     */
    @GetMapping("/:{boardId}")
    private BoardDto findByBoardId(@PathVariable Long boardId) {
        return this.boardService.findByBoardId(boardId);
    }

    /**
     * 게시글 등록
     * @param dto
     * @return Integer
     */
    @PostMapping
    private Integer saveBoard(@RequestBody BoardDto dto) {
        return this.boardService.saveBoard(dto);
    }

    /**
     * 게시글 수정
     * @param boardId
     * @param dto
     * @return Integer
     */
    @PutMapping("/:{boardId}")
    private Integer updateBoard(@PathVariable Long boardId, @RequestBody BoardDto dto) {
        return this.boardService.updateBoard(boardId, dto);
    }

    /**
     * 게시글 삭제
     * @param boardId
     * @return Integer
     */
    @DeleteMapping("/:{boardId}")
    private Integer deleteBoard(@PathVariable Long boardId) {
        return this.boardService.deleteBoard(boardId);
    }
}
