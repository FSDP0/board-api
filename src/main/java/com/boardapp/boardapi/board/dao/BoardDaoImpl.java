package com.boardapp.boardapi.board.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDaoImpl implements BoardDao {
    private final SqlSessionTemplate sqlSessionTemplate;

    private static final String namespace = "com.boardapp.boardapi.mapper.BoardMapper";

    @Override
    public List<Board> findAllBoards() {
        return this.sqlSessionTemplate.selectList(namespace + ".findAllBoards");
    }

    @Override
    public Board findByBoardId(Long boardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByBoardId'");
    }

    @Override
    public Integer saveBoard(Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveBoard'");
    }

    @Override
    public Integer updateBoard(Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBoard'");
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }

}
