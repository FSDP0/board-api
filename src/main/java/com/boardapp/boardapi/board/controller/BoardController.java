package com.boardapp.boardapi.board.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.model.BoardUpdateDto;
import com.boardapp.boardapi.board.model.BoardWithCreator;
import com.boardapp.boardapi.board.model.BoardWithEditor;
import com.boardapp.boardapi.board.service.BoardService;

@RestController
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;

    private BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    private List<Board> findAllBoards() throws Exception {
        return this.boardService.getAllBoards();
    }

    @GetMapping("/:{id}")
    private Board findBoardById(@PathVariable Long id) throws Exception {
        return this.boardService.getBoardById(id);
    }

    @GetMapping("/detail/write")
    private List<Board> findAllBoardWithWirter() throws Exception {
        return new ArrayList<Board>();
    }

    @GetMapping("/detail/write/:{id}")
    private BoardWithCreator findBoardWithWriterById(@PathVariable Long id) throws Exception {
        return this.boardService.getBoardWithCreatorById(id);
    }

    @GetMapping("/detail/modify")
    private List<Board> findAllBoardWithModify() throws Exception {
        return new ArrayList<Board>();
    }

    @GetMapping("/detail/modify/:{id}")
    private BoardWithEditor findBoardWithModifyById(@PathVariable Long id) throws Exception {
        return this.boardService.getBoardWithEditorById(id);
    }

    @PostMapping
    private void writeBoard(@RequestBody BoardSaveDto dto) throws Exception {
        this.boardService.saveBoard(dto);
    }

    @PutMapping("/:{id}")
    private void modifyBoard(@PathVariable Long id, @RequestBody BoardUpdateDto dto) throws Exception {
        this.boardService.updateBoard(id, dto);
    }

    @DeleteMapping("/:{id}")
    private void removeBoard(@PathVariable Long id) throws Exception {
        this.boardService.deleteBoard(id);
    }
}
