package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.mapper.BoardMapper;
import com.boardapp.boardapi.board.model.BoardDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> findAllBoards() {
        return new ArrayList<BoardDTO>();
    }

    @Override
    public BoardDTO findByBoardId(Long boardId) {
        return this.boardMapper.findByBoardId(boardId).toDto();
    }

    @Override
    public Integer saveBoard(BoardDTO dto) {
        return this.boardMapper.saveBoard(dto.toEntity());
    }

    @Override
    public Integer updateBoard(Long boardId, BoardDTO dto) {
        return this.boardMapper.updateBoard(dto.toEntity(boardId));
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        return this.boardMapper.deleteBoard(boardId);
    }
}
