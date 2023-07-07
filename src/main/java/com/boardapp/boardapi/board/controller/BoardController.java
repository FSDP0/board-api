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

    @GetMapping
    private List<BoardDto> findAllBoards(){
        return this.boardService.getAllBoards();
        // return this.boardCacheService.getCacheAll();
    }

    @GetMapping("/:{id}")
    private BoardDto findByBoardId(@PathVariable Long id){
        return this.boardService.getByBoardId(id);
        // return this.boardCacheService.getCacheByBoardId(id);
    }

    @PostMapping
    private void createBoard(@RequestBody BoardDto dto){
        this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{id}")
    private void editBoard(@PathVariable Long id,@RequestBody BoardDto dto){
        this.boardService.updateBoard(id,dto);
    }

    @DeleteMapping("/:{id}")
    private void removeBoard(@PathVariable Long id){
        this.boardService.deleteBoard(id);
    }
}
