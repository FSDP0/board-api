package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Getter;
import lombok.Setter;

// * 게시글 수정관련 데이터 전송객체
@Getter
@Setter
public class BoardEditDto {
    private String title;
    private String contents;

    private String modifyName; // Modify User ID value here

    public Board toEntity(Long boardId) {
        return Board.builder()
                        .id(boardId)
                        .title(this.title)
                        .contents(this.contents)
                        .modifyId(this.modifyName)
                        .modifyDate(Timestamp.valueOf(LocalDateTime.now()))
                        .build();
    }
}
