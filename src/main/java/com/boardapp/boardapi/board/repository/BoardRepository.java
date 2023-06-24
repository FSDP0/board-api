package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.entity.Board;
import lombok.extern.slf4j.Slf4j;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@Repository
public class BoardRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<Board> boardRowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Board> findAllBoards() {
        log.info("\\... Repository");

        String sql = BoardSql.SELECT_ALL;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        return this.namedParameterJdbcTemplate.query(sql, boardRowMapper);
    }

    public Board findBoardById(Long id) {
        log.info("\\... Repository");

        String sql = BoardSql.SELECT_BY_ID;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        SqlParameterSource namedParameter = new MapSqlParameterSource("board_id", id);

        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameter, boardRowMapper);
    }

    public void saveBoard(Board board) {
        log.info("\\... Repository");

        String sql = BoardSql.INSERT_BOARD;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        board.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(board);

        this.namedParameterJdbcTemplate.update(sql, namedParameterSource);
    }

    public void editBoard(Long id, Board board) {
        log.info("\\... Repository");

        String sql = BoardSql.UPDATE_BY_ID;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        board.setBoardId(id);
        board.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(board);

        this.namedParameterJdbcTemplate.update(sql, namedParameterSource);
    }

    public void deleteBoard(Long id) {
        log.info("\\... Repository");

        String sql = BoardSql.DELETE_BY_ID;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        SqlParameterSource namedParameter = new MapSqlParameterSource("boardId", id);

        this.namedParameterJdbcTemplate.update(sql, namedParameter);
    }
}
