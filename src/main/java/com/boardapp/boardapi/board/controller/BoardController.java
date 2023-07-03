package com.boardapp.boardapi.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.service.BoardService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController // * REST controller annotation
@RequestMapping("boards") // * 해당 컨트롤러가 기본적으로 사용할 Route 경로
public class BoardController {
    // ! Service dependency injection
    private final BoardService boardService;

    private BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    // !

    @GetMapping
    public Flux<Board> findAllBoards() {
        return this.boardService.getAllBoard();
    }

    @GetMapping("/:{id}")
    public Mono<ResponseEntity<Board>> findBoardById(@PathVariable Long id) {
        Mono<Board> board = this.boardService.getBoardById(id);

        return board.map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Board> saveBoard(@RequestBody BoardSaveDto dto) {
        return this.boardService.createBoard(dto);
    }

    @PutMapping("/:{id}")
    public Mono<ResponseEntity<Board>> editBoard(@PathVariable Long id, @RequestBody BoardEditDto dto) {
        return this.boardService.updateBoard(id, dto).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/:{id}")
    public Mono<ResponseEntity<Void>> deleteBoard(@PathVariable Long id) {
        return this.boardService.deleteBoard(id).map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
