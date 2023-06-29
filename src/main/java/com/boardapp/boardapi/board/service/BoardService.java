package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import com.boardapp.boardapi.board.entity.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardResponseDto> getAllBoards() {
        List<Board> boardList = this.boardRepository.findAllBoards();

        if (boardList.isEmpty()) {
            log.error("Board list is empty ...");

            return null;
        }

        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            BoardResponseDto dto = BoardResponseDto.builder().num(board.getBoardId())
                    .title(board.getBoardTitle()).contents(board.getBoardContents())
                    .writeId(board.getCreator()).modifyId(board.getEditor())
                    .writeDate(board.getWriteDate()).modifyDate(board.getModifyDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    public BoardResponseDto getBoardById(Long id) {
        Board board = this.boardRepository.findById(id).get();

        if (board == null) {
            return null;
        }

        BoardResponseDto dto = BoardResponseDto.builder().num(board.getBoardId())
                .title(board.getBoardTitle()).contents(board.getBoardContents())
                .writeId(board.getCreator()).modifyId(board.getEditor())
                .writeDate(board.getWriteDate()).modifyDate(board.getModifyDate()).build();

        return dto;
    }

    @Transactional
    public void saveBoard(BoardSaveDto dto) {
        this.boardRepository.save(dto.toEntity());
    }

    @Transactional
    public void updateBoard(Long id, BoardEditDto dto) {
        this.boardRepository.updateBoard(dto.getTitle(), dto.getContents(), dto.getEditId(),
                dto.getEditName(), id);
    }

    @Transactional
    public void deleteBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
