package com.boardapp.boardapi.board.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardEditDto;
import com.boardapp.boardapi.board.model.BoardSaveDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BoardService {
    // ! Repository dependency injection
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    // !

    // ! 게시글 전체 조회
    public Flux<Board> getAllBoard() {
        return this.boardRepository.findAll();
    }

    // ! 게시글 번호 기준 조회
    public Mono<Board> getBoardById(Long id) {
        return this.boardRepository.findById(id);
    }

    // // * 특정 사용자가 게시한 게시글 전체 조회
    // public Flux<Board> getAllBoardByWriteId(String userId) {
    // return this.boardRepository.findAllBoardsByWriteId(userId);
    // }

    // // * 특정 사용자가 게시한 게시글 단 건 조회
    // public Mono<Board> getBoardByWriteId(String userId) {
    // return this.boardRepository.findBoardByWriteId(userId);
    // }

    // // * 특정 사용자가 수정한 게시글 전체 조회
    // public Flux<Board> getAllBoardByModifyId(String userId) {
    // return this.boardRepository.findAllBoardsByModifyId(userId);
    // }

    // // * 특정 사용자가 수정한 게시글 단 건 조회
    // public Mono<Board> getBoardByModifyId(String userId) {
    // return this.boardRepository.findBoardByModifyId(userId);
    // }

    // ! 게시글 생성
    @Transactional
    public Mono<Board> createBoard(BoardSaveDto dto) {
        return this.boardRepository.save(dto.toEntity());
    }

    // ! 특정 게시글 수정
    @Transactional
    public Mono<Board> updateBoard(Long id, BoardEditDto dto) {
        return this.boardRepository.findById(id).flatMap(board -> {
            board.setBoardTitle(dto.getTitle());
            board.setBoardContents(dto.getContents());
            board.setModifyId(dto.getModifyName());
            board.setModifyDate(Timestamp.valueOf(LocalDateTime.now()));

            return this.boardRepository.save(board);
        });
    }

    // ! 특정 게시글 삭제
    @Transactional
    public Mono<Board> deleteBoard(Long id) {
        return this.boardRepository.findById(id).flatMap(board -> this.boardRepository.delete(board).then(Mono.just(board)));
    }
}
