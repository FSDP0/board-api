package com.boardapp.boardapi.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardCudDaoImpl implements BoardCudDao {
    @Resource(name = "cudSqlSessionTemplate")
    private final SqlSessionTemplate sqlSessionTemplate;

    private static final String NAMEPSACE = "BoardCudDao";

    @Override
    public Integer saveBoard(Board board) {
        return this.sqlSessionTemplate.insert(NAMEPSACE + ".saveBoard", board);
    }

    @Override
    public Integer updateBoard(Board board) {
        return this.sqlSessionTemplate.update(NAMEPSACE + ".updateBoard", board);
    }

    @Override
    public Integer deleteBoard(Long boardId) {
        return this.sqlSessionTemplate.delete(NAMEPSACE + ".deleteBoard", boardId);
    }

}
