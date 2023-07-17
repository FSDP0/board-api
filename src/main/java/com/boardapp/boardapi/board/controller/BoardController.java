package com.boardapp.boardapi.board.controller;

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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "RESTful API Guide for Boards", description = "게시글 정보 관련 CRUD")
@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "Find all post boards", description = "등록된 모든 게시글들을 조회합니다.")
    @GetMapping
    public Flux<BoardDto> findAllBoards() {
        return this.boardService.getAllBoards();
    }

    @Operation(summary = "Find specific post by board id", description = "특정 게시글을 번호로 조회합니다.")
    @GetMapping("/:{id}")
    public Mono<BoardDto> findByBoardId(@PathVariable Long id) {
        return this.boardService.getByBoardId(id);
    }

    @Operation(summary = "Post new board", description = "새로운 게시글을 작성합니다, 존재하는 사용자 정보를 작성해야 합니다.")
    @PostMapping
    public Mono<BoardDto> saveBoard(@RequestBody Mono<BoardDto> dtoMono) {
        return this.boardService.createBoard(dtoMono);
    }

    @Operation(summary = "Update posted board", description = "기존 게시글을 수정합니다. 게시글 수정자는 존재하는 사용자여야 합니다.")
    @PutMapping("/:{id}")
    public Mono<Integer> updateBoard(@PathVariable Long id, @RequestBody Mono<BoardDto> dtoMono) {
        return this.boardService.editBoard(id, dtoMono);
    }

    @Operation(summary = "Delete posted board by id", description = "기존 게시글 정보를 삭제합니다.")
    @DeleteMapping("/:{id}")
    public Mono<Void> deleteBoard(@PathVariable Long id) {
        return this.boardService.removeBoard(id);
    }
}
