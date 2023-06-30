package com.boardapp.boardapi.common.mapper.master;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.model.BoardWithCreator;
import com.boardapp.boardapi.board.model.BoardWithEditor;
import com.boardapp.boardapi.user.model.User;

public interface MasterDatabaseMapper {
    List<Board> getAllBoards() throws Exception;

    Board getBoardById(@Param("id") Long id) throws Exception;

    List<User> getAllUser() throws Exception;

    BoardWithCreator getBoardWithCreatorById(@Param("id") Long id) throws Exception;

    BoardWithEditor getBoardWithEditorById(@Param("id") Long id) throws Exception;

    void saveBoard(@Param("boardObj") Board board) throws Exception;

    void updateBoard(@Param("boardObj") Board board, @Param("id") Long id) throws Exception;

    void deleteBoard(@Param("id") Long id) throws Exception;
}
