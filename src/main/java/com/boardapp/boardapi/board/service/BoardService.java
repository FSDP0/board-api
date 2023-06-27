package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.model.BoardWithUserDto;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.model.BoardResponseWithUserDto;
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
        List<Board> boardList = this.boardRepository.selectAllBoard();

        if (boardList.isEmpty()) {
            log.error("Board list empty ....");

            return null;
        }

        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                    .title(board.getBoardTitle()) // 게시글 제목
                    .writerId(board.getCreatorId()) // 게시글 작성자 ID
                    .writer(board.getCreatorName()) // 게시글 작성자 이름
                    .editorId(board.getEditorId()) // 게시글 수정자 ID
                    .editor(board.getEditorName()) // 게시글 수정자 이름
                    .contents(board.getBoardContents()) // 게시글 내용
                    .createdDate(board.getCreatedDate()) // 게시글 작성일
                    .modifiedDate(board.getModifiedDate()) // 게시글 내용 변경일
                    .build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    public BoardResponseDto getBoardById(Long boardId) {
        Board board = this.boardRepository.selectBoardById(boardId);

        if (board == null) {
            log.error("Board not found ....");

            return null;
        }

        BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()) // 게시글 번호
                .title(board.getBoardTitle()) // 게시글 제목
                .writerId(board.getCreatorId()) // 게시글 작성자 ID
                .writer(board.getCreatorName()) // 게시글 작성자 이름
                .editorId(board.getEditorId()) // 게시글 수정자 ID
                .editor(board.getEditorName()) // 게시글 수정자 이름
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
        this.boardRepository.updateBoard(dto.toEntity(), id);;
    }

    @Transactional
    public void removeBoard(Long id) {
        this.boardRepository.deleteById(id);
    }

    public List<BoardResponseWithUserDto> getAllBoardsWithUser() {
        List<BoardWithUserDto> dataList = this.boardRepository.selectAllBoardWithUser();

        if (dataList.isEmpty()) {
            log.error("Data list empty ...");

            return null;
        }

        List<BoardResponseWithUserDto> dtoList = new ArrayList<BoardResponseWithUserDto>();

        for (BoardWithUserDto data : dataList) {
            BoardResponseWithUserDto dto = BoardResponseWithUserDto.builder().id(data.getNum())
                    .title(data.getTitle()).contents(data.getContents())
                    .writerId(data.getWriterId()).writer(data.getWriter())
                    .writerTel(data.getWriterTel()).writerAddress(data.getWriterAddress())
                    .writerAddressZipcode(data.getWriterAddressZipcode())
                    .editorId(data.getEditorId()).editor(data.getEditor())
                    .editorTel(data.getEditorTel()).editorAddress(data.getEditorAddress())
                    .editorAddressZipcode(data.getEditorAddressZipcode())
                    .createdDate(data.getWriteDate()).modifiedDate(data.getModifyDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    public BoardResponseWithUserDto getBoardWithUserById(Long id) {
        BoardWithUserDto data = this.boardRepository.selectBoardWithUserById(id);

        if (data == null) {
            log.error("Data is not exist");

            return null;
        }

        BoardResponseWithUserDto dto = BoardResponseWithUserDto.builder().id(data.getNum()).title(data.getTitle())
                .contents(data.getContents()).writerId(data.getWriterId()).writer(data.getWriter())
                .writerTel(data.getWriterTel()).writerAddress(data.getWriterAddress())
                .writerAddressZipcode(data.getWriterAddressZipcode()).editorId(data.getEditorId())
                .editor(data.getEditor()).editorTel(data.getEditorTel())
                .editorAddress(data.getEditorAddress())
                .editorAddressZipcode(data.getEditorAddressZipcode())
                .createdDate(data.getWriteDate()).modifiedDate(data.getModifyDate()).build();

        return dto;
    }
}
