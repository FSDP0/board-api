package com.boardapp.boardapi.board.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.board.entity.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
    @Query(value = BoardSQL.SELECT_ALL)
    public List<Board> findAllBoards();

    @Query(value = BoardSQL.SELECT_BY_ID)
    public Board findBoardById(@Param("id") Long id);

    @Modifying // [Dirty Tracking] / 변경된 데이터들만 Update 수행
    @Query(value = BoardSQL.UPDATE_BY_ID)
    public void updateBoard(@Param("title") String title, @Param("contents") String contents,
            @Param("editorId") String editorId, @Param("editorName") String editorName,
            @Param("id") Long id);
}
