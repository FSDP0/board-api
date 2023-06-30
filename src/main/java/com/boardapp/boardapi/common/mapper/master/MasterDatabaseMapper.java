package com.boardapp.boardapi.common.mapper.master;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;

public interface MasterDatabaseMapper {
    List<Board> getAllBoards() throws Exception;
}
