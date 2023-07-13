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
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public Flux<BoardDto> findAllBoards() {
        return this.boardService.getAllBoards();
    }

    @GetMapping("/:{id}")
    public Mono<BoardDto> findByBoardId(@PathVariable Long id){
        return this.boardService.getByBoardId(id);
    }

    @PostMapping
    public Mono<BoardDto> saveBoard(@RequestBody Mono<BoardDto> dtoMono){
        return this.boardService.createBoard(dtoMono);
    }

    @PutMapping("/:{id}")
    public Mono<Integer> updateBoard(@PathVariable Long id, @RequestBody Mono<BoardDto> dtoMono) {
        return this.boardService.editBoard(id, dtoMono);
    }

    @DeleteMapping("/:{id}")
    public Mono<Void> deleteBoard(@PathVariable Long id){
        return this.boardService.removeBoard(id);
    }
}
