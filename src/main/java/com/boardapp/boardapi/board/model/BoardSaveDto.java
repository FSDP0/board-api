package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.boardapp.boardapi.board.entity.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

// * 게시글 작성관련 데이터 전송객체
@Slf4j
@Getter
@Setter
public class BoardSaveDto {
    private String title;
    private String contents;

    private String writeName;

    public Board toEntity() {
        log.warn("[ Board Title ] : "+title);
        log.warn("[ Board Contents ] : "+ contents);
        log.warn("[ Write Id ] : "+writeName);

        return Board.builder()
                        .title(this.title)
                        .contents(this.contents)
                        .writeId(this.writeName)
                        .writeDate(Timestamp.valueOf(LocalDateTime.now()))
                        .build();
    }
}
