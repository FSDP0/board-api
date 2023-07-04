package com.boardapp.boardapi.common.mapper.master;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.board.model.BoardWithUser;
import com.boardapp.boardapi.user.model.User;
import com.boardapp.boardapi.user.model.UserWithAddress;

// ! [ Master Database Mapper ] Interface methods matching with .xml mapper file id
public interface MasterDatabaseMapper {
    // ! 게시글 관련 Interface methods
    // * 모든 게시글 조회
    List<Board> getAllBoards() throws Exception;

    // * 모든 게시글의 세부 사용자 정보를 함께 조회
    @Select(
        """
        SELECT *
        FROM board A
        LEFT OUTER JOIN user B
        ON A.write_id = B.user_id
        """
    )
    List<BoardWithUser> getAllBoardsWithUser() throws Exception;

    // * 특정 게시글 번호 기준 조회
    Board getByBoardId(@Param("id") Long id) throws Exception;

    // * 특정 게시글을 세부 사용자 정보와 함께 조회
    BoardWithUser getBoardWithUserByBoardId(@Param("id") Long id) throws Exception;

    // * 특정 사용자가 작성한 게시글 목록 조회
    List<Board> getByWriteId(@Param("write_id") String writeId) throws Exception;

    // * 특정 사용자가 수정한 게시글 목록 조회
    List<Board> getByModifyId(@Param("modify_id") String modifyId) throws Exception;

    // * 게시글 작성
    void saveBoard(@Param("boardObj") Board board) throws Exception;

    // * 게시글 수정
    void updateBoard(@Param("boardObj") Board board, @Param("id") Long id) throws Exception;

    // * 게시글 삭제
    void deleteBoard(@Param("id") Long id) throws Exception;

    // ! 사용자 계정 관련 Interface methods
    // * 모든 사용자 계정 정보를 조회
    List<User> getAllUser() throws Exception;

    // * 모든 사용자 계정 정보를 상세 주소정보와 함께 조회
    List<UserWithAddress> getAllUserWithAddress() throws Exception;

    // * 특정 사용자 정보를 ID 기준으로 조회
    User getByUserId(@Param("userId") String userId) throws Exception;

    // * 특정 사용자 정보를 상세 주소와 함께 ID로 조회
    UserWithAddress getUserWithAddressByUserId(@Param("userId") String userId) throws Exception;

    // * 사용자 계정정보 등록
    void saveUser(@Param("userObj") User user) throws Exception;

    // * 특정 사용자 계정정보 수정
    void updateUser(@Param("userObj") User user, @Param("userId") Long userId) throws Exception;

    // * 특정 사용자 계정정보 삭제
    void deleteUser(@Param("userId") String userId) throws Exception;
}
