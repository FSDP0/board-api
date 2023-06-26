package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.model.BoardUserDto;
import com.boardapp.boardapi.board.model.BoardEditDto;
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
                    .writerId(board.getBoardCreatorId()) // 게시글 작성자 ID
                    .writer(board.getBoardCreatorName()) // 게시글 작성자 이름
                    .editorId(board.getBoardEditorId()) // 게시글 수정자 ID
                    .editor(board.getBoardEditorName())// 게시글 수정자 이름
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
            log.error("Board not found ....");

            return null;
        }

        BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                .title(board.getBoardTitle()) // 게시글 제목
                .writerId(board.getBoardCreatorId()) // 게시글 작성자 ID
                .writer(board.getBoardCreatorName()) // 게시글 작성자 이름
                .editor(board.getBoardEditorId()) // 게시글 수정자 ID
                .editor(board.getBoardEditorName()) // 게시글 수정자 이름
                .contents(board.getBoardContents()) // 게시글 내용
                .createdDate(board.getCreatedDate()) // 게시글 생성일
                .modifiedDate(board.getModifiedDate()) // 게시글 변경일
                .build();

        return dto;
    }

    @Transactional
    public void createBoard(BoardSaveDto dto) {
        this.boardRepository.save(dto.toEntity());
    }

    @Transactional
    public void modifyBoard(Long id, BoardEditDto dto) {
        Board prevEntity = this.boardRepository.findById(id).get();

        Board board = Board.builder().id(id) // 게시글 번호
                .title(dto.getTitle()) // 게시글 제목
                .creatorId(prevEntity.getBoardCreatorId()) // 게시글 생성자 ID
                .creatorName(prevEntity.getBoardCreatorName()) // 게시글 생성자 이름
                .contents(dto.getContents()) // 게시글 내용
                .editorId(dto.getEditId()) // 게시글 수정자 ID
                .editorName(dto.getEditName()) // 게시글 수정자 이름
                .createdDate(prevEntity.getCreatedDate()).build();

        this.boardRepository.save(board);
    }

    @Transactional
    public void removeBoard(Long id) {
        this.boardRepository.deleteById(id);
    }

    // @Transactional
    // public BoardUserDto sample(Long id) {
    // return this.boardRepository.findByBoardId(id);
    // }
}
