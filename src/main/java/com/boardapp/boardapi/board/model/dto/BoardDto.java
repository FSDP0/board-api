package com.boardapp.boardapi.board.model.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.boardapp.boardapi.board.model.Board;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {
    private Long num;               // ? Board Index

    private String title;           // ? Board Title
    private String contents;        // ? Board Contents

    private String writeName;       // ? Board Author
    private String modifyName;      // ? Board Editor

    private Date writeDate;         // ? Board Written Date
    private Date modifyDate;        // ? Board Edited Date

    // * Convert DTO to Save Entity using Builder
    public Board toEntity(){
        return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .writeId(this.writeName)
                    .writeDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }

    // * Convert DTO to Update Entity using Builder
    public Board toEntity(Long id){
        return Board.builder()
                    .id(this.num)   // ! Required field for update
                    .title(this.title)
                    .contents(this.contents)
                    .modifyId(this.modifyName)
                    .modifyDate(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
    }
}
