package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import com.boardapp.boardapi.board.entity.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import com.boardapp.boardapi.user.repository.UserRepository;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public List<BoardDto> getAllBoards() {
        Iterable<Board> boardList = this.boardRepository.findAll();

        List<BoardDto> dtoList = new ArrayList<BoardDto>();

        for (Board board : boardList) {
            dtoList.add(board.toDto());
        }

        return dtoList;
    }

    public BoardDto getBoardById(Long id) {
        return this.boardRepository.findById(id).get().toDto();
    }

    @Transactional
    public void saveBoard(BoardDto dto) {
        this.boardRepository.save(dto.toEntity());
    }

    @Transactional
    public void updateBoard(Long id, BoardDto dto) {
        this.boardRepository.updateBoard(dto.toEntity(id));
    }

    @Transactional
    public void deleteBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
