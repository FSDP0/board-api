package com.boardapp.boardapi.board.repository;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSQL;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer updateBoard(Board board) {
        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(board);

        return this.namedParameterJdbcTemplate.update(BoardSQL.UPDATE_BY_ID, namedParameterSource);
    }
}
