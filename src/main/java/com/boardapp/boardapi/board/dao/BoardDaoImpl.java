package com.boardapp.boardapi.board.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao {
    private final SqlSessionTemplate sqlSessionTemplate;

    private static final String namespace = "BoardDao";

    @Override
    public List<Board> findAllBoards() {
        return this.sqlSessionTemplate.selectList(namespace + ".findAllBoards");
    }

    @Override
    public Board findByBoardId(Long boardId) {
        return this.sqlSessionTemplate.selectOne(namespace + ".findByBoardId", boardId);
    }

    @Override
    public Integer saveBoard(Board board) {
        return this.sqlSessionTemplate.insert(namespace + ".saveBoard", board);
    }

    @Override
    public Integer updateBoard(Board board) {
        return this.sqlSessionTemplate.update(namespace + ".updateBoard", board);
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        return this.sqlSessionTemplate.delete(namespace + ".deleteBoard", boardId);
    }

}
