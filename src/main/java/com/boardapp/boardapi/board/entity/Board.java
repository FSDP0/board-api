package com.boardapp.boardapi.board.entity;

import java.util.Date;
import com.boardapp.boardapi.board.model.BoardDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board {
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    private String writeName;
    private String modifyName;

    private Date writeDate;
    private Date modifyDate;

    // * Convert Entity to DTO
    public BoardDto toDto() {
        return BoardDto.builder()
                        .num(this.boardId)
                        .title(this.boardTitle)
                        .contents(this.boardContents)
                        .writeName(this.writeName)
                        .modifyName(this.modifyName)
                        .createdDate(this.writeDate)
                        .modifiedDate(this.modifyDate)
                        .build();
    }
}
