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
import com.boardapp.boardapi.board.model.dto.BoardResponseDto;
import com.boardapp.boardapi.board.model.dto.BoardSaveDto;
import com.boardapp.boardapi.board.model.dto.BoardUpdateDto;
import com.boardapp.boardapi.board.service.BoardService;

@RestController
@RequestMapping("boards")
public class BoardController {
    // ! Dependency injection
    private final BoardService boardService;

    private BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    // !

    @GetMapping // * 모든 게시글 조회
    private List<BoardResponseDto> findAllBoards() throws Exception {
        return this.boardService.getAllBoards();
    }

    // @GetMapping("/detail") // * 모든 게시글을 세부 사용자 정보와 함께 조회
    // private List<BoardWithUserResponseDto> findAllBoardsWithUser() throws Exception {
    // return this.boardService.getAllBoardsWithUser();
    // }

    @GetMapping("/:{id}") // * 특정 게시글 번호를 기준으로 게시글 조회
    private BoardResponseDto findByBoardId(@PathVariable Long id) throws Exception {
        return this.boardService.getByBoardId(id);
    }

    // @GetMapping("/detail/:{id}") // * 특정 게시글의 세부 사용자 정보를 함께 조회
    // private BoardWithUserResponseDto findBoardWithUserByBoardId(@PathVariable Long id) throws
    // Exception {
    // return this.boardService.getBoardWithUserByBoardId(id);
    // }

    // @GetMapping("/detail/write/:{userId}") // * 특정 사용자가 작성한 모든 게시글 조회
    // private List<BoardResponseDto> findAllByWriteId(@PathVariable String userId) throws Exception {
    // return this.boardService.getByWriteId(userId);
    // }

    // @GetMapping("/detail/modify/:{userId}") // * 특정 사용자가 수정한 모든 게시글 조회
    // private List<BoardResponseDto> findAllByModifyId(@PathVariable String userId) throws Exception {
    // return this.boardService.getByModifyId(userId);
    // }

    @PostMapping // * 게시글 등록
    private void writeBoard(@RequestBody BoardSaveDto dto) throws Exception {
        this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{id}") // * 특정 게시글 수정
    private void modifyBoard(@PathVariable Long id, @RequestBody BoardUpdateDto dto) throws Exception {
        this.boardService.updateBoard(id, dto);
    }

    @DeleteMapping("/:{id}") // * 특정 게시글 삭제
    private void removeBoard(@PathVariable Long id) throws Exception {
        this.boardService.deleteBoard(id);
    }
}
