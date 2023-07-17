package com.boardapp.boardapi.board.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.dao.BoardCudDao;
import com.boardapp.boardapi.board.dao.BoardReadDao;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardReadDao boardReadDao;
    private final BoardCudDao boardCudDao;

    @Override
    public List<Board> findAllBoards() {
        return this.boardReadDao.findAllBoards();
    }

    @Override
    public Board findByBoardId(Long boardId) {
        return this.boardReadDao.findByBoardId(boardId);
    }

    @Override
    public Integer saveBoard(Board dto) {
        dto.setWriteDate(LocalDateTime.now());

        return this.boardCudDao.saveBoard(dto);
    }

    @Override
    public Integer updateBoard(Long boardId, Board dto) {
        dto.setBoardId(boardId);
        dto.setModifyDate(LocalDateTime.now());

        return this.boardCudDao.updateBoard(dto);
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        return this.boardCudDao.deleteBoard(boardId);
    }
}
