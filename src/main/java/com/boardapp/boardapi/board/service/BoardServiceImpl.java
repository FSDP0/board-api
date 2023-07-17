package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.dao.BoardDao;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.model.BoardDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardDao boardDao;

    @Override
    public List<BoardDto> findAllBoards() {
        List<Board> boardList = this.boardDao.findAllBoards();

        List<BoardDto> dtoList = new ArrayList<BoardDto>();

        for(Board board : boardList) {
            dtoList.add(board.toDto());
        }

        return dtoList;
    }

    @Override
    public BoardDto findByBoardId(Long boardId) {
        return this.boardDao.findByBoardId(boardId).toDto();
    }

    @Override
    @Transactional
    public Integer saveBoard(BoardDto dto) {
        return this.boardDao.saveBoard(dto.toEntity());
    }

    @Override
    @Transactional
    public Integer updateBoard(Long boardId, BoardDto dto) {
        return this.boardDao.updateBoard(dto.toEntity(boardId));
    }

    @Override
    @Transactional
    public Integer deleteBoard(Long boardId) {
        return this.boardDao.deleteBoard(boardId);
    }
}
