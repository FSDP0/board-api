package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Getter;
import lombok.ToString;

// * 게시글 작성관련 데이터 전송객체
@Getter
@ToString
public class BoardSaveDto {

    private String title;
    private String contents;

    private String writeName;

    public Board toEntity() {
        Board board = Board.builder().title(this.title).contents(this.contents).writeId(this.writeName)
                .writeDate(Timestamp.valueOf(LocalDateTime.now())).build();

        return board;
    }
}
