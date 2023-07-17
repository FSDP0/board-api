package com.boardapp.boardapi.board.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardReadDaoImpl implements BoardReadDao {
    @Resource(name = "readSqlSessionTemplate")
    private final SqlSessionTemplate sqlSessionTemplate;

    private static final String NAMESPACE = "BoardReadDao";

    @Override
    public List<Board> findAllBoards() {
        return this.sqlSessionTemplate.selectList(NAMESPACE + ".findAllBoards");
    }

    @Override
    public Board findByBoardId(Long boardId) {
        return this.sqlSessionTemplate.selectOne(NAMESPACE + ".findByBoardId", boardId);
    }
}
