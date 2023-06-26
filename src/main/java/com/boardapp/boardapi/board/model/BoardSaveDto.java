package com.boardapp.boardapi.board.model;

import com.boardapp.boardapi.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

// Mapping with thymeleaf template variables
@Getter
public class BoardSaveDto {
    private Long num;

    private String title;

    private String writeId;
    private String writeName;

    private String contents;

    public Board toEntity() {
        Board board = Board.builder().id(this.num) // 게시글 번호
                .title(this.title) // 게시글 제목
                .creatorId(this.writeId) // 게시글 작성자 ID
                .creatorName(this.writeName) // 게시글 작성자 이름
                .contents(this.contents) // 게시글 내용
                .build();

        return board;
    }

    @Builder
    public BoardSaveDto(Long id, String title, String writerId, String writerName,
            String contents) {
        this.num = id;

        this.title = title;
        this.writeId = writerId;
        this.writeName = writerName;
        this.contents = contents;
    }
}
