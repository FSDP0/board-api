package com.boardapp.boardapi.board.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.entity.Board;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardRepository {
    private final JdbcTemplate jdbcTemplate;
    private final BoardSQLProps boardSQLProps;

    private final RowMapper<Board> boardMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardRepository(JdbcTemplate jdbcTemplate, BoardSQLProps boardSQLProps) {
        this.jdbcTemplate = jdbcTemplate;
        this.boardSQLProps = boardSQLProps;
    }

    public List<Board> findAllBoard() {
        log.info("\\... Repository");

        String sql = boardSQLProps.getSELECT_ALL();

        log.info("\n[ Sending SQL Query ] " + sql);

        return this.jdbcTemplate.query(sql, boardMapper);
    }

    public Board findBoardById(Long id) {
        log.info("\\... Repository");

        String sql = boardSQLProps.getSELECT_BY_ID();

        log.info("\n[ Sending SQL Query ] " + sql);

        return this.jdbcTemplate.queryForObject(sql, boardMapper, id);
    }

    public void saveBoard(Board board) {
        log.info("\\... Repository");

        String sql = boardSQLProps.getINSERT_BOARD();

        log.info("\n[ Sending SQL Query ] " + sql);

        this.jdbcTemplate.update(sql, board.getBoardTitle(), board.getUserId(),
                board.getBoardContents(), LocalDateTime.now());
    }

    public void editBoard(Long id, Board board) {
        log.info("\\... Repository");

        String sql = boardSQLProps.getUPDATE_BY_ID();

        log.info("\n[ Sending SQL Query ] " + sql);

        this.jdbcTemplate.update(sql, board.getBoardTitle(), board.getBoardContents(),
                LocalDateTime.now(), id);
    }

    public void deleteBoard(Long id) {
        log.info("\\... Repository");

        String sql = boardSQLProps.getDELETE_BY_ID();

        log.info("\n[ Sending SQL Query ] " + sql);

        this.jdbcTemplate.update(sql, id);
    }
}
