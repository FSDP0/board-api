package com.boardapp.boardapi.board.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.sql.BoardSql;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Board> boardRowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Board> findAllBoards() {
        log.info("\\... Repository");

        String sql = BoardSql.SELECT_ALL;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        return this.jdbcTemplate.query(sql, boardRowMapper);
    }

    public Board findBoardById(Long id) {
        log.info("\\... Repository");

        String sql = BoardSql.SELECT_BY_ID;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        return this.jdbcTemplate.queryForObject(sql, boardRowMapper, id);
    }

    public void saveBoard(Board board) {
        log.info("\\... Repository");

        String sql = BoardSql.INSERT_BOARD;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        this.jdbcTemplate.update(sql, board.getBoardTitle(), board.getUserId(),
                board.getBoardContents(), LocalDateTime.now());
    }

    public void editBoard(Long id, Board board) {
        log.info("\\... Repository");

        String sql = BoardSql.UPDATE_BY_ID;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        this.jdbcTemplate.update(sql, board.getBoardTitle(), board.getBoardContents(),
                LocalDateTime.now(), id);
    }

    public void deleteBoard(Long id) {
        log.info("\\... Repository");

        String sql = BoardSql.DELETE_BY_ID;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        this.jdbcTemplate.update(sql, id);
    }
}
