package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.repository.BoardRepository;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BoardService(BoardRepository boardRepository,
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.boardRepository = boardRepository;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<BoardResponseDto> getAllBoard() {
        List<Board> boardList = this.boardRepository.selectAllBoards();

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
        Board board = this.boardRepository.selectBoardById(id);

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
