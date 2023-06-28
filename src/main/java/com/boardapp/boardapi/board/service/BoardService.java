package com.boardapp.boardapi.board.service;

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
            if (board.getEditorId() == null) {
                log.warn("Board Editor Id is null ...");

                BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                        .title(board.getBoardTitle()) // 게시글 제목
                        .writerId(board.getCreator().getUserId()) // 작성자 ID
                        .writerName(board.getCreator().getUserName()) // 작성자 이름
                        .writerTel(board.getCreator().getUserTel()) // 작성자 전화번호
                        .writerAddress(board.getCreator().getUserAddress()) // 작성자 주소
                        .writerAddressZipcode(board.getCreator().getAddressZipcode()) // 작성자 ZipCode
                        .contents(board.getBoardContents()) // 게시글 내용
                        .createdDate(board.getCreatedDate()) // 게시글 작성일
                        .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                        .build();

                dtoList.add(dto);
            } else {
                log.info("Board Editor Id is not null ...");

                BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                        .title(board.getBoardTitle()) // 게시글 제목
                        .writerId(board.getCreator().getUserId()) // 작성자 ID
                        .writerName(board.getCreator().getUserName()) // 작성자 이름
                        .writerTel(board.getCreator().getUserTel()) // 작성자 전화번호
                        .writerAddress(board.getCreator().getUserAddress()) // 작성자 주소
                        .writerAddressZipcode(board.getCreator().getAddressZipcode()) // 작성자 ZipCode
                        .editorId(board.getEditor().getUserId()) // 수정자 ID
                        .editorName(board.getEditor().getUserName()) // 수정자 이름
                        .editorTel(board.getEditor().getUserTel()) // 수정자 전화번호
                        .editorAddress(board.getEditor().getUserAddress()) // 수정자 주소
                        .editorAddressZipcode(board.getEditor().getAddressZipcode()) // 수정자 ZipCode
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
        Board board = this.boardRepository.findById(boardId).get();

        if (board == null) {
            log.error("Board not found ....");

            return null;
        }

        if (board.getEditorId() == null) {
            log.warn("Board Editor Id is not exist ...");

            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                    .title(board.getBoardTitle()) // 게시글 제목
                    .writerId(board.getCreator().getUserId()) // 작성자 ID
                    .writerName(board.getCreator().getUserName()) // 작성자 이름
                    .writerTel(board.getCreator().getUserTel()) // 작성자 전화번호
                    .writerAddress(board.getCreator().getUserAddress()) // 작성자 주소
                    .writerAddressZipcode(board.getCreator().getAddressZipcode()) // 작성자 ZipCode
                    .contents(board.getBoardContents()) // 게시글 내용
                    .createdDate(board.getCreatedDate()) // 게시글 작성일
                    .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                    .build();

            return dto;
        } else {
            log.info("Board Editor Id is exist ...");

            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                    .title(board.getBoardTitle()) // 제목
                    .writerId(board.getCreator().getUserId()) // 작성자 ID
                    .writerName(board.getCreator().getUserName()) // 작성자 이름
                    .writerTel(board.getCreator().getUserTel()) // 작성자 전화번호
                    .writerAddress(board.getCreator().getUserAddress()) // 작성자 주소
                    .writerAddressZipcode(board.getCreator().getAddressZipcode()) // 작성자 ZipCode
                    .editorId(board.getEditor().getUserId()) // 수정자 ID
                    .editorName(board.getEditor().getUserName()) // 수정자 이름
                    .editorTel(board.getEditor().getUserTel()) // 수정자 전화번호
                    .editorAddress(board.getEditor().getUserAddress()) // 수정자 주소
                    .editorAddressZipcode(board.getEditor().getAddressZipcode()) // 수정자 ZipCode
                    .contents(board.getBoardContents()) // 게시글 내용
                    .createdDate(board.getCreatedDate()) // 게시글 작성일
                    .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                    .build();

            return dto;
        }
    }

    @Transactional
    public void createBoard(BoardSaveDto dto) {
        this.boardRepository.saveBoard(dto.toEntity());
    }

    @Transactional
    public void modifyBoard(Long id, BoardEditDto dto) {
        this.boardRepository.updateBoard(dto.toEntity(), id);
    }

    @Transactional
    public void removeBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
