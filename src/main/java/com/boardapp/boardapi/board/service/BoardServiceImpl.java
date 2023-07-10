package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.dao.BoardDao;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.model.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    // ! DAO dependency injection
    private final BoardDao boardDao;

    // * 모든 게시글 조회
    @Override
    public List<BoardDto> getAllBoards() {
        List<Board> boardList = this.boardDao.findAllBoards();

        if (boardList.isEmpty()) {
            log.error("Board list is empty ...");

            return null;
        }

        List<BoardDto> dtoList = new ArrayList<BoardDto>();

        for (Board board : boardList) {
            dtoList.add(board.toDto());
        }

        return dtoList;
    }

    // * 게시글 번호 기준 조회
    @Override
    public BoardDto getByBoardId(Long id) {
        Board board = this.boardDao.findByBoardId(id);

        if (board == null) {
            log.error("Board not exist ...");

            return null;
        }

        return board.toDto();
    }

    // * 게시글 작성
    @Override
    @Transactional
    public void saveBoard(BoardDto saveDto) {
        this.boardDao.saveBoard(saveDto.toEntity());
        // this.masterDatabaseBoardMapper.saveBoard(saveDto.toEntity());
    }

    // * 특정 게시글 수정
    @Override
    @Transactional
    public void updateBoard(Long id, BoardDto updateDto) {
        // this.masterDatabaseBoardMapper.updateBoard(updateDto.toEntity(id));
    }

    // * 특정 게시글 삭제
    @Override
    @Transactional
    public void deleteBoard(Long id) {
        // this.masterDatabaseBoardMapper.deleteBoard(id);
    }
}
