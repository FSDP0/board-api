package com.boardapp.boardapi.board.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSql;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    // ! Dependency injection
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // ! RowMapper with Entity 
    private final RowMapper<Board> boardRowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    // * 게시자 기준 게시글 전체 조회
    @Override
    public List<Board> findAllBoardsByWriteId(String userId) {
        String sql = BoardSql.SELECT_BY_WRITER;

        return this.jdbcTemplate.query(sql, boardRowMapper, userId);
    }

    // * 게시자 기준 게시글 전체 조회
    @Override
    public Board findBoardByWriteId(String userId) {
        String sql = BoardSql.SELECT_BY_WRITER;

        return this.jdbcTemplate.queryForObject(sql, boardRowMapper, userId);
    }

    // * 수정자 기준 게시글 전체 조회
    @Override
    public List<Board> findAllBoardsByModifyId(String userId) {
        String sql = BoardSql.SELECT_BY_EDITOR;

        return this.jdbcTemplate.query(sql, boardRowMapper, userId);
    }

    // * 수정자 기준 게시글 단건 조회
    @Override
    public Board findBoardByModifyId(String userId) {
        String sql = BoardSql.SELECT_BY_EDITOR;

        this.jdbcTemplate.queryForObject(sql, boardRowMapper, userId);

        return this.jdbcTemplate.queryForObject(sql, boardRowMapper, userId);
    }

    // ! Update with Named JDBC Template Native Query
    @Override
    public Integer updateBoard(Board board) {
        String sql = BoardSql.UPDATE_BY_ID;

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(board);

        return this.namedParameterJdbcTemplate.update(sql, namedParameterSource);
    }
}
