package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardDto> getAllBoards() {
        Iterable<Board> boardList = this.boardRepository.findAll();

        List<BoardDto> dtoList = new ArrayList<BoardDto>();

        for (Board board : boardList) {
            dtoList.add(board.toDto());
        }

        return dtoList;
    }

    public BoardDto getByBoardId(Long id) {
        return this.boardRepository.findById(id).get().toDto();
    }

    public void createBoard(BoardDto dto) {
        this.boardRepository.save(dto.toEntity());
    }

    public void editBoard(Long id, BoardDto dto) {
        this.boardRepository.updateBoard(dto.toEntity(id));
    }

    public void removeBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
