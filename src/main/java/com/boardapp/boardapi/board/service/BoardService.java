package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public List<BoardResponseDto> getAllBoards() {
        List<Board> boardList = this.boardRepository.selectAllBoard();

        if (boardList.isEmpty()) {
            log.error("Board list empty ....");

            return null;
        }

        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            if (board.getEditorId() == null) {
                BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                        .title(board.getBoardTitle()) // 게시글 제목
                        .writerId(board.getCreatorId().getUserId()) // 게시글 작성자 ID
                        .writer(board.getCreatorId().getUserName()) // 게시글 작성자 이름
                        .contents(board.getBoardContents()) // 게시글 내용
                        .createdDate(board.getCreatedDate()) // 게시글 작성일
                        .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                        .build();

                dtoList.add(dto);
            } else {
                BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                        .title(board.getBoardTitle()) // 게시글 제목
                        .writerId(board.getCreatorId().getUserId()) // 게시글 작성자 ID
                        .writer(board.getCreatorId().getUserName()) // 게시글 작성자 이름
                        .editorId(board.getEditorId().getUserId()) // 게시글 수정자 ID
                        .editor(board.getEditorId().getUserName()) // 게시글 수정자 이름
                        .contents(board.getBoardContents()) // 게시글 내용
                        .createdDate(board.getCreatedDate()) // 게시글 작성일
                        .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                        .build();

                dtoList.add(dto);
            }
        }

        return dtoList;
    }

    public BoardResponseDto getBoardById(Long boardId) {
        Board board = this.boardRepository.selectBoardById(boardId);

        if (board == null) {
            log.error("Board not found ....");

            return null;
        }

        if (board.getEditorId() == null) {
            log.warn("Board editor not exist ...");

            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                    .title(board.getBoardTitle()) // 게시글 제목
                    .writerId(board.getCreatorId().getUserId()) // 게시글 작성자 ID
                    .writer(board.getCreatorId().getUserName()) // 게시글 작성자 이름
                    .contents(board.getBoardContents()) // 게시글 내용
                    .createdDate(board.getCreatedDate()) // 게시글 생성일
                    .modifiedDate(board.getModifiedDate()) // 게시글 변경일
                    .build();

            return dto;
        }

        BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                .title(board.getBoardTitle()) // 게시글 제목
                .writerId(board.getCreatorId().getUserId()) // 게시글 작성자 ID
                .writer(board.getCreatorId().getUserName()) // 게시글 작성자 이름
                .editorId(board.getEditorId().getUserId()) // 게시글 수정자 ID
                .editor(board.getEditorId().getUserName()) // 게시글 수정자 이름
                .contents(board.getBoardContents()) // 게시글 내용
                .createdDate(board.getCreatedDate()) // 게시글 생성일
                .modifiedDate(board.getModifiedDate()) // 게시글 변경일
                .build();

        return dto;
    }

    public void createBoard(BoardSaveDto dto) {
        User user = this.userRepository.findById(dto.getWriteId()).get();

        Board board = Board.builder().title(dto.getTitle()).creatorId(user)
                .contents(dto.getContents()).build();

        this.boardRepository.saveBoard(board);
    }

    @Transactional
    public void modifyBoard(Long id, BoardEditDto dto) {
        Board prevEntity = this.boardRepository.findById(id).get();

        Board board = Board.builder().id(id) // 게시글 번호
                .title(dto.getTitle()) // 게시글 제목
                // .creatorId(prevEntity.getBoardCreatorId()) // 게시글 생성자 ID
                // .creatorName(prevEntity.getBoardCreatorName()) // 게시글 생성자 이름
                .contents(dto.getContents()) // 게시글 내용
                // .editorId(dto.getEditId()) // 게시글 수정자 ID
                // .editorName(dto.getEditName()) // 게시글 수정자 이름
                .createdDate(prevEntity.getCreatedDate()).build();

        this.boardRepository.save(board);
    }

    @Transactional
    public void removeBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
