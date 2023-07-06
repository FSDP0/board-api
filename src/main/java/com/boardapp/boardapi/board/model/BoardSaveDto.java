package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Getter;

// * 게시글 작성관련 데이터 전송객체
@Getter
public class BoardSaveDto {
    private String title;
    private String contents;

    private String writeName;

    public Board toEntity() {
        return Board.builder()
                        .title(this.title)
                        .contents(this.contents)
                        .writeId(this.writeName)
                        .writeDate(Timestamp.valueOf(LocalDateTime.now()))
                        .build();
    }
}
