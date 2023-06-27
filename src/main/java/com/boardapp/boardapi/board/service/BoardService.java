package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.model.BoardWithUserDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import com.boardapp.boardapi.board.repository.BoardWithUserRepository;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardWithUserRepository boardWithUserRepository;

    public BoardService(BoardRepository boardRepository,
            BoardWithUserRepository boardWithUserRepository) {
        this.boardRepository = boardRepository;
        this.boardWithUserRepository = boardWithUserRepository;
    }

    public List<BoardResponseDto> getAllBoard() {
        List<Board> boardList = this.boardRepository.findAllBoards();

        if (boardList.isEmpty()) {
            return null;
        }

        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            BoardResponseDto dto = BoardResponseDto.builder().num(board.getBoardId())
                    .title(board.getBoardTitle()).contents(board.getBoardContents())
                    .writeId(board.getCreatorId()).writeName(board.getCreatorName())
                    .modifyId(board.getEditorId()).modifyName(board.getEditorName())
                    .writeDate(board.getCreatedDate()).modifyDate(board.getModifiedDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    public BoardResponseDto getBoardById(Long id) {
        Board board = this.boardRepository.findBoardById(id);

        if (board == null) {
            return null;
        }

        BoardResponseDto dto = BoardResponseDto.builder().num(board.getBoardId())
                .title(board.getBoardTitle()).contents(board.getBoardContents())
                .writeId(board.getCreatorId()).writeName(board.getCreatorName())
                .modifyId(board.getEditorId()).modifyName(board.getEditorName())
                .writeDate(board.getCreatedDate()).modifyDate(board.getModifiedDate()).build();

        return dto;
    }

    public BoardWithUserDto getBoardWithUserById(Long id) {
        return this.boardWithUserRepository.findBoardWithUserById(id);
    }

    @Transactional
    public void createBoard(BoardSaveDto dto) {
        this.boardRepository.save(dto.toEntity());
    }

    @Transactional
    public void updateBoard(Long id, BoardEditDto dto) {
        this.boardRepository.updateBoard(dto.getTitle(), dto.getContents(), dto.getEditId(),
                dto.getEditName(), id);
    }

    @Transactional
    public void removeBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
