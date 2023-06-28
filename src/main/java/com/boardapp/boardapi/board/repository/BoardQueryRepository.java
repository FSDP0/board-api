package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardWithUserReponseDto;
import com.boardapp.boardapi.board.repository.sql.BoardSQL;

@Repository
public interface BoardQueryRepository {
    final RowMapper<BoardWithUserReponseDto> boardWithUserMapper =
            BeanPropertyRowMapper.newInstance(BoardWithUserReponseDto.class);

    @Query(value = BoardSQL.SELECT_ALL)
    List<BoardWithUserReponseDto> findAllWithUser();
}
