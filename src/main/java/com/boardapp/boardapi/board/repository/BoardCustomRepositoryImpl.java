package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.repository.sql.BoardSql;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Board> boardRowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardCustomRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // * 게시자 기준 게시글 전체 조회
    public Flux<Board> findAllBoardsByWriteId(String userId) {
        String sql = BoardSql.SELECT_BY_WRITER;

        List<Board> boardList = this.jdbcTemplate.query(sql, boardRowMapper, userId);

        return Flux.fromIterable(boardList);
    }

    // * 게시자 기준 게시글 전체 조회
    public Mono<Board> findBoardByWriteId(String userId) {
        String sql = BoardSql.SELECT_BY_WRITER;

        Board board = this.jdbcTemplate.queryForObject(sql, boardRowMapper, userId);

        return Mono.just(board);
    }

    // * 수정자 기준 게시글 전체 조회
    public Flux<Board> findAllBoardsByModifyId(String userId) {
        String sql = BoardSql.SELECT_BY_EDITOR;

        List<Board> boardList = this.jdbcTemplate.query(sql, boardRowMapper, userId);

        return Flux.fromIterable(boardList);
    }

    // * 수정자 기준 게시글 단건 조회
    public Mono<Board> findBoardByModifyId(String userId) {
        String sql = BoardSql.SELECT_BY_EDITOR;

        Board board = this.jdbcTemplate.queryForObject(sql, boardRowMapper, userId);

        return Mono.just(board);
    }
}
