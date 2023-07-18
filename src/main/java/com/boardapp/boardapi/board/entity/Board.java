package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "board")
public class Board {
    @Id
    private Long boardId;

    private String boardTitle;
    private String boardContents;

    @Transient
    @Setter
    @Column("write_id")
    private User writeId;

    @Transient
    @Setter
    @Column("modify_id")
    private User editorId;

    @Column("write_id")
    private String creator;

    @Column("modify_id")
    private String editor;

    @CreatedDate
    private Date writeDate;

    @LastModifiedDate
    private Date modifyDate;

    public BoardDto toDto() {
        return BoardDto.builder()
                        .num(this.boardId)
                        .title(this.boardTitle)
                        .contents(this.boardContents)
                        .writeId(this.creator)
                        .modifyId(this.editor)
                        .writeDate(this.writeDate)
                        .modifyDate(this.modifyDate)
                        .build();
    }
}
