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

    private static final String NAMESPACE = "BoardDao";

    @Override
    public List<Board> findAllBoards() {
        return this.sqlSessionTemplate.selectList(NAMESPACE + ".findAllBoards");
    }

    @Override
    public Board findByBoardId(Long boardId) {
        return this.sqlSessionTemplate.selectOne(NAMESPACE + ".findByBoardId", boardId);
    }

    @Override
    public Board findByQuery(Board board) {
        return this.sqlSessionTemplate.selectOne(NAMESPACE + ".findByQuery", board);
    }

    @Override
    public Integer saveBoard(Board board) {
        return this.sqlSessionTemplate.insert(NAMESPACE + ".saveBoard", board);
    }

    @Override
    public Integer updateBoard(Board board) {
        return this.sqlSessionTemplate.update(NAMESPACE + ".updateBoard", board);
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        return this.sqlSessionTemplate.delete(NAMESPACE + ".deleteBoard", boardId);
    }

}
