package com.boardapp.boardapi.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardReponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    // ! Dependency injection
    private final BoardService boardService;

    @GetMapping
    private Flux<BoardReponseDto> getAllBoards() {
        return this.boardService.getAllBoards();
    }

    @GetMapping("/:{id}")
    private Mono<BoardReponseDto> getByBoardId(@PathVariable Long id) {
        return this.boardService.getByBoardId(id);
    }

    @PostMapping
    private Mono<Void> createBoard(@RequestBody Mono<BoardSaveDto> boardDtoMono) {

        return this.boardService.saveBoard(boardDtoMono);
    }
    
    @PutMapping("/:{id}")
    private Mono<Void> editBoard(@PathVariable Long id, @RequestBody Mono<BoardEditDto> boardDtoMono) {
        return this.boardService.updateBoard(id, boardDtoMono);
    }

    @DeleteMapping("/:{id}")
    private Mono<Void> removeBoard(@PathVariable Long id){
        return this.boardService.deleteBoard(id);
    }
}
