package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSql;

@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Board> boardRowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardCustomRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // * 게시자 기준 게시글 전체 조회
    public List<Board> findAllBoardsByWriteId(String userId) {
        String sql = BoardSql.SELECT_BY_WRITER;

        return this.jdbcTemplate.query(sql, boardRowMapper, userId);
    }

    // * 게시자 기준 게시글 전체 조회
    public Board findBoardByWriteId(String userId) {
        String sql = BoardSql.SELECT_BY_WRITER;

        return this.jdbcTemplate.queryForObject(sql, boardRowMapper, userId);
    }

    // * 수정자 기준 게시글 전체 조회
    public List<Board> findAllBoardsByModifyId(String userId) {
        String sql = BoardSql.SELECT_BY_EDITOR;

        return this.jdbcTemplate.query(sql, boardRowMapper, userId);
    }

    // * 수정자 기준 게시글 단건 조회
    public Board findBoardByModifyId(String userId) {
        String sql = BoardSql.SELECT_BY_EDITOR;

        this.jdbcTemplate.queryForObject(sql, boardRowMapper, userId);

        return this.jdbcTemplate.queryForObject(sql, boardRowMapper, userId);
    }

}
