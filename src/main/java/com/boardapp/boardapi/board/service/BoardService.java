package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardResponseDto;
import com.boardapp.boardapi.board.model.BoardWithUserReponseDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // public List<BoardResponseDto> getAllBoard() {
    // Iterable<Board> boardList = this.boardRepository.findAll();

    // // if (boardList.isEmpty()) {
    // // return null;
    // // }

    // List<BoardResponseDto> dtoList = new ArrayList<BoardResponseDto>();

    // // for (BoardWithUserReponseDto board : boardList) {
    // // log.info(board.toString());
    // // log.info(board.getWritePhoneNumber());

    // // BoardResponseDto dto = BoardResponseDto.builder().num(board.getBoardId()) // 게시글 번호
    // // .title(board.getBoardTitle()) // 게시글 제목
    // // .contents(board.getBoardContents()) // 게시글 내용
    // // .writeId(board.getWriteId()) // 게시자 Id
    // // .writeName(board.getWriteName()) // 게시자 이름
    // // .writePhoneNumber(board.getWritePhoneNumber()).modifyId(board.getModifyId()) // 수정자
    // // // Id
    // // .modifyName(board.getModifyName()) // 수정자 이름
    // // .writeDate(board.getWriteDate()) // 게시일
    // // .modifyDate(board.getModifyDate()) // 수정일
    // // .build();

    // // dtoList.add(dto);
    // // }

    // return dtoList;
    // }

    // public List<BoardWithUserReponseDto> getAllBoardDetail() {
    // return this.boardRepository.selectAllBoards();
    // }

    // public BoardResponseDto getBoardById(Long id) {
    // // Board board = this.boardRepository.selectBoardById(id);
    // Board board = this.boardRepository.findById(id).get();

    // if (board == null) {
    // return null;
    // }

    // BoardResponseDto dto = BoardResponseDto.builder().num(board.getBoardId()) // 게시글 번호
    // .title(board.getBoardTitle()) // 게시글 제목
    // .contents(board.getBoardContents()) // 게시글 내용
    // .writeId(board.getWriteId()) // 게시자 Id
    // .writeName(board.getWriteName()) // 게시자 이름
    // .modifyId(board.getModifyId()) // 수정자 Id
    // .modifyName(board.getModifyName()) // 수정자 이름
    // .writeDate(board.getWriteDate()) // 게시일
    // .modifyDate(board.getModifyDate()) // 수정일
    // .build();

    // return dto;
    // }

    // public BoardWithUserReponseDto getBoardByIdDetail(Long id) {
    // return this.boardRepository.selectBoardById(id);
    // }

    // @Transactional
    // public void createBoard(BoardSaveDto dto) {
    // this.boardRepository.save(dto.toEntity());
    // }

    // @Transactional
    // public void updateBoard(Long id, BoardEditDto dto) {
    // this.boardRepository.updateBoard(dto.getTitle(), dto.getContents(), dto.getEditId(),
    // dto.getEditName(), id);
    // }

    // @Transactional
    // public void removeBoard(Long id) {
    // this.boardRepository.deleteById(id);
    // }

    public Iterable<Object> sample() {
        return this.boardRepository.sample();
    }
}
