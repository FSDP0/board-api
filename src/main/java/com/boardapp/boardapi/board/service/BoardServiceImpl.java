package com.boardapp.boardapi.board.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.dao.BoardDao;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardDao boardDao;

    @Override
    public List<Board> findAllBoards() {
        return this.boardDao.findAllBoards();
    }

    @Override
    public Board findByBoardId(Long boardId) {
        return this.boardDao.findByBoardId(boardId);
    }

    @Override
    public Board findByQuery(Long boardId, String writeId, String modifyId) {
        return this.boardDao.findByQuery(Board.builder().boardId(boardId).writeId(writeId).modifyId(modifyId).build());
    }

    @Override
    @Transactional
    public Integer saveBoard(Board dto) {
        dto.setWriteDate(LocalDateTime.now());

        return this.boardDao.saveBoard(dto);
    }

    @Override
    @Transactional
    public Integer updateBoard(Long boardId, Board dto) {
        dto.setBoardId(boardId);
        dto.setModifyDate(LocalDateTime.now());

        return this.boardDao.updateBoard(dto);
    }

    @Override
    @Transactional
    public Integer deleteBoard(Long boardId) {
        return this.boardDao.deleteBoard(boardId);
    }

}
