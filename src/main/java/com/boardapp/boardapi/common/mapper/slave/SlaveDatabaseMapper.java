package com.boardapp.boardapi.common.mapper.slave;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.user.model.User;

// ! [ Slave Database Mapper ] Interface methods matching with .xml mapper file id
public interface SlaveDatabaseMapper {
    List<Board> getAllBoards() throws Exception;

    List<User> getAllUser() throws Exception;
}
