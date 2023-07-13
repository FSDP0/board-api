package com.boardapp.boardapi.board.entity;

import java.util.Date;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.user.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    @JsonBackReference  // ? Do not serialize for JSON [Reference Backward]
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "creator_id", insertable = false, updatable = false)
    private User creator;

    @Column(name = "editor_id", nullable = true)
    private String editorId;

    @JsonBackReference  // ? Do not serialize for JSON [Reference Backward]
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @Fetch(FetchMode.JOIN) // ! FetchMode.JOIN, editor는 존재하지만 creator는 null인 경우, FetchMode로 해결
    @JoinColumn(name = "editor_id", insertable = false, updatable = false)
    private User editor;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    public BoardDto toDto(){
        log.debug("=============== Board Convert Entity to DTO ===============");
        log.debug("BoardId : {}", this.boardId);
        log.debug("BoardTitle : {}", this.boardTitle);
        log.debug("BoardContents : {}", this.boardContents);
        log.debug("WriteId : {}", this.creatorId);

        if(this.creator == null) {
            log.debug("Creator Object is Null");
        }

        log.debug("ModifyId : {}", this.editorId);

        if(this.editor == null) {
            log.debug("Editor Object is Null");
        }

        log.debug("CreatedDate : {}", this.createdDate);
        log.debug("ModifiedDate : {}", this.modifiedDate);

        // * Save Response
        if(this.creatorId != null && this.creator == null) {
            return BoardDto.builder()
                            .num(this.boardId)
                            .title(this.boardTitle)
                            .contents(this.boardContents)
                            .writeId(this.creatorId)
                            .writeDate(this.createdDate)
                            .modifyDate(this.modifiedDate)
                            .build();
        }

        // * Modify Response
        if(this.editorId != null && this.editor == null) {
                        return BoardDto.builder()
                            .num(this.boardId)
                            .title(this.boardTitle)
                            .contents(this.boardContents)
                            .modifyId(this.editorId)
                            .writeDate(this.createdDate)
                            .modifyDate(this.modifiedDate)
                            .build();
        }

        // * 게시글 작성자가 없는데, 수정자가 있는 경우, 수정자 정보만 변환
        if(this.creatorId == null) {
            return BoardDto.builder()
                            .num(this.boardId)
                            .title(this.boardTitle)
                            .contents(this.boardContents)
                            .modifyId(this.editorId)
                            .modifyName(this.editor.getUserName())
                            .modifyTel(this.editor.getUserTel())
                            .writeDate(this.createdDate)
                            .modifyDate(this.modifiedDate)
                            .build();
        } 

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
