package com.boardapp.boardapi.board.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardSaveDto;
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

    @Transactional
    public List<BoardResponseDto> getAllBoards() {
        List<Board> boardList = this.boardRepository.selectAllBoard();

        if (boardList.isEmpty()) {
            log.error("Board list empty ....");

            return null;
        }

        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            if (board.getEditor() == null) {
                BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                        .title(board.getBoardTitle()) // 게시글 제목
                        .writerId(board.getCreator().getUserId()) // 게시글 작성자
                        .writer(board.getCreator().getUserName()) // 게시글 작성자 이름
                        .contents(board.getBoardContents()) // 게시글 내용
                        .createdDate(board.getCreatedDate()) // 게시글 작성일
                        .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                        .build();

                dtoList.add(dto);
            } else {
                BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                        .title(board.getBoardTitle()) // 게시글 제목
                        .writerId(board.getCreator().getUserId()) // 게시글 작성자 ID
                        .writer(board.getCreator().getUserName()) // 게시글 작성자 이름
                        .editorId(board.getEditor().getUserId()) // 게시글 수정자 ID
                        .editor(board.getEditor().getUserName()) // 게시글 수정자 이름
                        .contents(board.getBoardContents()) // 게시글 내용
                        .createdDate(board.getCreatedDate()) // 게시글 작성일
                        .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                        .build();

                dtoList.add(dto);
            }
        }

        return dtoList;
    }

    @Transactional
    public BoardResponseDto getBoardById(Long boardId) {
        Board board = this.boardRepository.selectBoardById(boardId);

        if (board == null) {
            log.error("Board not found ....");

            return null;
        }

        if (board.getEditor() == null) {
            log.warn("Board editor not exist ...");

            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                    .title(board.getBoardTitle()) // 게시글 제목
                    .writerId(board.getCreator().getUserId()) // 게시글 작성자 ID
                    .writer(board.getCreator().getUserName()) // 게시글 작성자 이름
                    .contents(board.getBoardContents()) // 게시글 내용
                    .createdDate(board.getCreatedDate()) // 게시글 생성일
                    .modifiedDate(board.getModifiedDate()) // 게시글 변경일
                    .build();

            return dto;
        }

        BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                .title(board.getBoardTitle()) // 게시글 제목
                .writerId(board.getCreator().getUserId()) // 게시글 작성자 ID
                .writer(board.getCreator().getUserName()) // 게시글 작성자 이름
                .editorId(board.getEditor().getUserId()) // 게시글 수정자 ID
                .editor(board.getEditor().getUserName()) // 게시글 수정자 이름
                .contents(board.getBoardContents()) // 게시글 내용
                .createdDate(board.getCreatedDate()) // 게시글 생성일
                .modifiedDate(board.getModifiedDate()) // 게시글 변경일
                .build();

        return dto;
    }

    public void createBoard(BoardSaveDto dto) {
        this.boardRepository.saveBoard(dto.toEntity());
    }

    @Transactional
    public void modifyBoard(Long id, BoardEditDto dto) {

        Board board = Board.builder().title(dto.getTitle()).contents(dto.getContents())
                .editorId(dto.getEditId()).modifiedDate(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        this.boardRepository.updateBoard(board, id);
    }

    @Transactional
    public void removeBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
