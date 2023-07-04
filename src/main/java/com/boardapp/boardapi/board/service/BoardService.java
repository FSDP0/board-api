package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.model.BoardWithUser;
import com.boardapp.boardapi.board.model.dto.BoardResponseDto;
import com.boardapp.boardapi.board.model.dto.BoardSaveDto;
import com.boardapp.boardapi.board.model.dto.BoardUpdateDto;
import com.boardapp.boardapi.board.model.dto.BoardWithUserResponseDto;
import com.boardapp.boardapi.common.mapper.master.MasterDatabaseMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
    // ! [ Master ] Database mapper dependency injection
    private final MasterDatabaseMapper masterDatabaseMapper;

    public BoardService(MasterDatabaseMapper masterDatabaseMapper) {
        this.masterDatabaseMapper = masterDatabaseMapper;
    }
    // !

    // * 모든 게시글 조회
    public List<BoardResponseDto> getAllBoards() throws Exception {
        List<Board> boardList = this.masterDatabaseMapper.getAllBoards();

        if (boardList.isEmpty()) {
            log.error("Board list is empty ...");

            return null;
        }

        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()).title(board.getBoardTitle())
                    .contents(board.getBoardContents()).writeId(board.getWriteId()).modifyId(board.getModifyId())
                    .writeDate(board.getWriteDate()).modifyDate(board.getModifyDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    // * 모든 게시글을 세부 사용자 정보와 함께 조회
    public List<BoardWithUserResponseDto> getAllBoardsWithUser() throws Exception {
        List<BoardWithUser> dataList = this.masterDatabaseMapper.getAllBoardsWithUser();

        if (dataList == null) {
            log.error("Board data list is empty ...");

            return null;
        }

        List<BoardWithUserResponseDto> dtoList = new ArrayList<BoardWithUserResponseDto>();

        for (BoardWithUser data : dataList) {
            BoardWithUserResponseDto dto =
                    BoardWithUserResponseDto.builder().num(data.getBoardId()).title(data.getBoardTitle()).contents(data.getBoardContents())
                            .writeId(data.getWriteId()).writeName(data.getCreatorName()).writeTel(data.getCreatorTel())
                            .writeAddress(data.getCreatorAddress()).writeDetailAddress(data.getCreatorDetailAddress())
                            .writeAddressZipcode(data.getEditorAddressZipcode()).modifyId(data.getModifyId())
                            .modifyName(data.getEditorName()).modifyTel(data.getEditorTel()).modifyAddress(data.getEditorAddress())
                            .modifyDetailAddress(data.getEditorDetailAddress()).modifyAddressZipcode(data.getEditorAddressZipcode())
                            .writeDate(data.getWriteDate()).modifyDate(data.getModifyDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    // * 게시글 번호 기준 조회
    public BoardResponseDto getByBoardId(Long id) throws Exception {
        Board board = this.masterDatabaseMapper.getByBoardId(id);

        if (board == null) {
            log.error("Board not exist ...");

            return null;
        }

        BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()).title(board.getBoardTitle())
                .contents(board.getBoardContents()).writeId(board.getWriteId()).modifyId(board.getModifyId())
                .writeDate(board.getWriteDate()).modifyDate(board.getModifyDate()).build();

        return dto;
    }

    // * 특정 게시글을 세부 사용자 정보와 함께 조회
    public BoardWithUserResponseDto getBoardWithUserByBoardId(Long id) throws Exception {
        BoardWithUser data = this.masterDatabaseMapper.getBoardWithUserByBoardId(id);

        if (data == null) {
            log.error("Board not exist ...");

            return null;
        }
        log.error(data.toString());

        BoardWithUserResponseDto dto = BoardWithUserResponseDto.builder().num(data.getBoardId()).title(data.getBoardTitle())
                .contents(data.getBoardContents()).writeId(data.getWriteId()).writeName(data.getCreatorName())
                .writeTel(data.getCreatorTel()).writeAddress(data.getCreatorAddress()).writeDetailAddress(data.getCreatorDetailAddress())
                .writeAddressZipcode(data.getEditorAddressZipcode()).modifyId(data.getModifyId()).modifyName(data.getEditorName())
                .modifyTel(data.getEditorTel()).modifyAddress(data.getEditorAddress()).modifyDetailAddress(data.getEditorDetailAddress())
                .modifyAddressZipcode(data.getEditorAddressZipcode()).writeDate(data.getWriteDate()).modifyDate(data.getModifyDate())
                .build();

        return dto;
    }

    // * 특정 사용자가 작성한 모든 게시글
    public List<BoardResponseDto> getByWriteId(String userId) throws Exception {
        List<Board> boardList = this.masterDatabaseMapper.getByWriteId(userId);

        if (boardList.isEmpty()) {
            log.error("Board list is empty ...");

            return null;
        }

        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()).title(board.getBoardTitle())
                    .contents(board.getBoardContents()).writeId(board.getWriteId()).modifyId(board.getModifyId())
                    .writeDate(board.getWriteDate()).modifyDate(board.getModifyDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    // * 특정 사용자가 수정한 모든 게시글
    public List<BoardResponseDto> getByModifyId(String userId) throws Exception {
        List<Board> boardList = this.masterDatabaseMapper.getByModifyId(userId);

        if (boardList.isEmpty()) {
            log.error("Board list is empty ...");

            return null;
        }

        List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

        for (Board board : boardList) {
            BoardResponseDto dto = BoardResponseDto.builder().id(board.getBoardId()).title(board.getBoardTitle())
                    .contents(board.getBoardContents()).writeId(board.getWriteId()).modifyId(board.getModifyId())
                    .writeDate(board.getWriteDate()).modifyDate(board.getModifyDate()).build();

            dtoList.add(dto);
        }

        return dtoList;
    }

    // * 게시글 작성
    @Transactional
    public void saveBoard(BoardSaveDto saveDto) throws Exception {
        this.masterDatabaseMapper.saveBoard(saveDto.toEntity());
    }

    // * 특정 게시글 수정
    @Transactional
    public void updateBoard(Long id, BoardUpdateDto updateDto) throws Exception {
        this.masterDatabaseMapper.updateBoard(updateDto.toEntity(), id);
    }

    // * 특정 게시글 삭제
    @Transactional
    public void deleteBoard(Long id) throws Exception {
        this.masterDatabaseMapper.deleteBoard(id);
    }
}
