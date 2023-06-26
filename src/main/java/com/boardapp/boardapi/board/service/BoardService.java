package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardPayloadDto;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardResponseDto> getAllBoards() {
        List<Board> boardList = this.boardRepository.findAll();

        if (boardList.isEmpty()) {
            log.error("Board list empty ....");

            return null;
        }
        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                    .title(board.getBoardTitle()) // 게시글 제목
                    .writer(board.getBoardCreator().getUserId()) // 게시글 작성자
                    .contents(board.getBoardContents()) // 게시글 내용
                    .createdDate(board.getCreatedDate()) // 게시글 작성일
                    .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                    .build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    public BoardResponseDto getBoardById(Long boardId) {
        Board board = this.boardRepository.findById(boardId).get();

        if (board == null) {
            return null;
        }

        BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                .title(board.getBoardTitle()) // 게시글 제목
                .writer(board.getBoardCreator().getUserId()) // 게시글 작성자
                .contents(board.getBoardContents()) // 게시글 내용
                .createdDate(board.getCreatedDate()) // 게시글 생성일
                .modifiedDate(board.getModifiedDate()) // 게시글 변경일
                .build();

        return dto;
    }

    @Transactional
    public void createBoard(BoardPayloadDto payload) {
        this.boardRepository.save(payload.toEntity());
    }

    @Transactional
    public void modifyBoard(Long id, BoardPayloadDto payload) {
        Date createdDate = this.boardRepository.findById(id).get().getCreatedDate();

        Board board =
                Board.builder().id(id).title(payload.getTitle()).author(payload.getWriteName())
                        .contents(payload.getContents()).createdDate(createdDate).build();

        this.boardRepository.save(board);
    }

    @Transactional
    public void removeBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
