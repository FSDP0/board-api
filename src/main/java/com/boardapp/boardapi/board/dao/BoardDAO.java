package com.boardapp.boardapi.board.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.model.Board;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDAO {
    private final SqlSessionTemplate sqlSessionTemplate;

    public List<Board> findAllBoards() {
        return this.sqlSessionTemplate.selectList(null);
    }

    public Board findByBoardId(){
        return this.sqlSessionTemplate.selectOne(null);
    }

    public Integer saveBoard() {
        return this.sqlSessionTemplate.update(null);
    }

    public Integer updateBoard() {
        return this.sqlSessionTemplate.update(null);
    }

    public Integer deleteBoard() {
        return this.sqlSessionTemplate.delete(null);
    }
}
