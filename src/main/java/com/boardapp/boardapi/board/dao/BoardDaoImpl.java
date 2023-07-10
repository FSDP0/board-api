package com.boardapp.boardapi.board.dao;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

@Repository("boardDao")
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao{
    // ! SqlSessionTemplate dependency injection
    @Resource(name="cudSqlSessionTemplate")
    private final SqlSessionTemplate cudSqlSessionTemplate;

    @Resource(name="readSqlSessionTemplate")
    private final SqlSessionTemplate readSqlSessionTemplate;
    // !

    private final String findAllBoards  = "com.boardapp.boardapi.board.mapper.BoardReadMapper.getAllBoards";
    private final String findByBoardId  = "com.boardapp.boardapi.board.mapper.BoardReadMapper.getByBoardId";
    private final String saveBoard      = "com.boardapp.boardapi.board.mapper.BoardCudMapper.saveBoard";
    private final String updateBoard    = "com.boardapp.boardapi.board.mapper.BoardCudMapper.updateBoard";
    private final String deleteBoard    = "com.boardapp.boardapi.board.mapper.BoardCudMapper.deleteBoard";

    @Override
    public List<Board> findAllBoards() {
        List<Board> boardList = this.readSqlSessionTemplate.selectList(findAllBoards);

        return boardList;
    }

    @Override
    public Board findByBoardId(Long boardId) {
        return this.readSqlSessionTemplate.selectOne(findByBoardId, boardId);
    }

    @Override
    public void saveBoard(Board board) {
        this.cudSqlSessionTemplate.insert(saveBoard, board);
    }

    @Override
    public void updateBoard(Board board) {
        this.cudSqlSessionTemplate.update(updateBoard, board);
    }

    @Override
    public void deleteBoard(Long boardId) {
        this.cudSqlSessionTemplate.delete(deleteBoard, boardId);

    }
    
}
