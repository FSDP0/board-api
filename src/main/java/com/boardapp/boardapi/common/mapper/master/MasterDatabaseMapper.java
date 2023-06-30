package com.boardapp.boardapi.common.mapper.master;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.user.model.User;

public interface MasterDatabaseMapper {
    List<Board> getAllBoards() throws Exception;

    List<User> getAllUser() throws Exception;
}
