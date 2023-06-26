package com.boardapp.boardapi.board.model;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardUserDto {
    private Long boardId; // PK Column

    private String boardTitle;

    private String boardCreatorId;

    private String boardCreatorName;

    private String boardContents;

    private Date createdDate;

    private String boardEditorId;

    private String boardEditorName;

    private Date modifiedDate;

    @Builder
    public BoardUserDto(Long id, String title, String writerId, String writer, String editorId,
            String editor, String contents, Date createdDate, Date modifiedDate) {
        this.boardId = id;

        this.boardTitle = title;
        this.boardContents = contents;

        this.boardCreatorId = writerId;
        this.boardCreatorName = writer;

        this.boardEditorId = editorId;
        this.boardEditorName = editor;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
