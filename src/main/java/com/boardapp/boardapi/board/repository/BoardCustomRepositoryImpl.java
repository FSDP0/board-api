package com.boardapp.boardapi.board.repository;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSql;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void updateBoard(Board board) {
        String sql = BoardSql.UPDATE_BY_ID;

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(board);

        this.namedParameterJdbcTemplate.update(sql, namedParameterSource);
    }
    
}
