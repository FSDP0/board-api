package com.boardapp.boardapi.board.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.mapper.BoardMapper;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    @Override
    public List<Board> findAllBoards() {
        return this.boardMapper.findAllBoards();
    }

    @Override
    public Board findByBoardId(Long boardId) {
        return this.boardMapper.findByBoardId(boardId);
    }

    @Override
    public Integer saveBoard(Board dto) {
        dto.setWriteDate(LocalDateTime.now());

        return this.boardMapper.saveBoard(dto);
    }

    @Override
    public Integer updateBoard(Long boardId, Board dto) {
        dto.setBoardId(boardId);
        dto.setModifyDate(LocalDateTime.now());

        return this.boardMapper.updateBoard(dto);
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        return this.boardMapper.deleteBoard(boardId);
    }
}
