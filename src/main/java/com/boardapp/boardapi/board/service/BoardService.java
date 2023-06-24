package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardDto> getAllBoards() {
        log.info("\\... Serivce");

        List<Board> boardList = this.boardRepository.findAllBoard();

        if (boardList.isEmpty()) {
            log.error("Received user list empty ...");

            return null;
        }

        List<BoardDto> boardDtoList = new ArrayList<BoardDto>();

        for (Board board : boardList) {
            BoardDto boardDto = BoardDto.builder().num(board.getBoardId())
                    .title(board.getBoardTitle()).writeName(board.getUserId())
                    .contents(board.getBoardContents()).writeDate(board.getCreatedDate())
                    .modifyDate(board.getModifiedDate()).build();

            boardDtoList.add(boardDto);
        }

        log.info("[ Success Process ] All board data convert to dto");

        return boardDtoList;
    }

    public BoardDto getBoardById(Long id) {
        log.info("\\... Serivce");

        Board board = this.boardRepository.findBoardById(id);

        if (board == null) {
            log.error("User not exist ...");

            return null;
        }

        BoardDto boardDto = BoardDto.builder().num(board.getBoardId()).title(board.getBoardTitle())
                .writeName(board.getUserId()).contents(board.getBoardContents())
                .writeDate(board.getCreatedDate()).modifyDate(board.getModifiedDate()).build();

        log.info("[ Success Process ] Board data convert to dto");

        return boardDto;
    }

    public void createBoard(BoardDto boardDto) {
        log.info("\\... Serivce");
        this.boardRepository.saveBoard(boardDto.toEntity());
    }

    public void modifyBoard(Long id, BoardDto boardDto) {
        log.info("\\... Serivce");
        this.boardRepository.editBoard(id, boardDto.toEntity());
    }

    public void removeBoard(Long id) {
        log.info("\\... Serivce");
        this.boardRepository.deleteBoard(id);
    }
}
