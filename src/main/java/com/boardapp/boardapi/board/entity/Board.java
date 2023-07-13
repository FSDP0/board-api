package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_title", length = 100)
    private String boardTitle;

    @Column(name = "board_contents", length = 255)
    private String boardContents;

    @Column(name = "creator_id")
    private String creatorId;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", insertable = false, updatable = false)
    private User creator;

    @Column(name = "editor_id", nullable = true)
    private String editorId;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "editor_id", insertable = false, updatable = false)
    private User editor;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    public BoardDto toDto(){
        // * 만일 아직 게시글 수정자가 없는 경우, 작성자 정보만 변환
        if (this.editorId == null) {
            return BoardDto.builder()
                            .num(this.boardId)
                            .title(this.boardTitle)
                            .contents(this.boardContents)
                            .writeId(this.creatorId)
                            .writeName(this.creator.getUserName())
                            .writeTel(this.creator.getUserTel())
                            .writeDate(this.createdDate)
                            .modifyDate(this.modifiedDate)
                            .build();
        }
        // * 게시글 수정자 정보까지 기본적으로 모두 변환
        return BoardDto.builder()
                        .num(this.boardId)
                        .title(this.boardTitle)
                        .contents(this.boardContents)
                        .writeId(this.creatorId)
                        .writeName(this.creator.getUserName())
                        .writeTel(this.creator.getUserTel())
                        .modifyId(this.editorId)
                        .modifyName(this.editor.getUserName())
                        .modifyTel(this.editor.getUserTel())
                        .writeDate(this.createdDate)
                        .modifyDate(this.modifiedDate)
                        .build();
    }
}
