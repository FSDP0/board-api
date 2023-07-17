package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.mapper.BoardMapper;
import com.boardapp.boardapi.board.model.BoardDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDto> findAllBoards() {
        return new ArrayList<BoardDto>();
    }

    @Override
    public BoardDto findByBoardId(Long boardId) {
        return this.boardMapper.findByBoardId(boardId).toDto();
    }

    @Override
    public Integer saveBoard(BoardDto dto) {
        return this.boardMapper.saveBoard(dto.toEntity());
    }

    @Override
    public Integer updateBoard(Long boardId, BoardDto dto) {
        return this.boardMapper.updateBoard(dto.toEntity(boardId));
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        return this.boardMapper.deleteBoard(boardId);
    }
}
