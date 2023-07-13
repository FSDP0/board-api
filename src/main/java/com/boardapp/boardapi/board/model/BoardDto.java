package com.boardapp.boardapi.board.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.boardapp.boardapi.board.entity.Board;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {
    private Long num;

    private String title;
    private String contents;

    private String writeId;
    private String writeName;
    private String writeTel;

    private String modifyId;
    private String modifyName;
    private String modifyTel;

    private Date writeDate;
    private Date modifyDate;

    // * Convert DTO to Save Entity
    public Board toEntity(){
        log.warn("============ Convert DTO to Entity ============");
        log.warn("Board Title : {}",this.title);
        log.warn("Board Contents : {}",this.contents);
        log.warn("Board Creator Id: {}",this.writeId);
        log.warn("Board Created Date : {}",this.writeDate);
        log.warn("Board Modified Date : {}",this.modifyDate);

        return Board.builder()
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .creatorId(this.writeId)
                    .build();
    }

    // * Convert DTO to Update Entity
    public Board toEntity(Long boardId){
        log.warn("============ Convert DTO to Entity ============");
        log.warn("Board Index Number : {}",boardId);
        log.warn("Board Title : {}",this.title);
        log.warn("Board Contents : {}",this.contents);
        log.warn("Board Creator Id: {}",this.writeId);
        log.warn("Board Modifier Id : {}", this.modifyId);
        log.warn("Board Created Date : {}",this.writeDate);
        log.warn("Board Modified Date : {}",this.modifyDate);


        return Board.builder()
                    .boardId(boardId) // ! This id field must be required
                    .boardTitle(this.title)
                    .boardContents(this.contents)
                    .editorId(this.modifyId)
                    .modifiedDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }
}
