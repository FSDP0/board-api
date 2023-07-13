package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import com.boardapp.boardapi.common.util.RedisOperator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    // ! Dependency injection
    private final BoardRepository boardRepository;
    private final RedisOperator<BoardDto> redisOperator;

    // ! Cache Identification Basic Key
    private static String BOARD_KEY = "BOARD:NUM";
    
    // ? Cache Data는 Client측에서 필요한 경우에 Cache Hit를 통해 접근
    // ? Cache Data의 TTL(Time to Live)은 어느정도로 설정해야 하는가?
    // ? Cache Data가 CRUD 작업에서 Set되고, Delete되어야 하는 순간은 어느 시점인가?
    // ! Cache Data의 Hit비율에 근거하여, Redis에 저장되어지는 시간 즉, TTL(Time to Live)의 설정시간이 달라져야 한다.

    // ! List는 반드시 필수적인 경우에만 사용 권고
    public List<BoardDto> getAllBoards() {
        List<BoardDto> dtoList = new ArrayList<BoardDto>();
        
        Iterable<Board> boardList = this.boardRepository.findAll();
        
        for (Board board : boardList) {
            dtoList.add(board.toDto());
        }

        return dtoList;
    }

    public BoardDto getByBoardId(Long id) {
        String key = BOARD_KEY + id;

        BoardDto dto = redisOperator.getValue(key);

        if(dto == null) {
            log.warn("No cache data, Request data from database ...");

            dto = this.boardRepository.findById(id).get().toDto();

            redisOperator.set(key, dto, Long.valueOf(10), TimeUnit.SECONDS);
        } else {
            log.info("Request data from Redis Cache Success ...");
        }

        return dto;
    }

    // ! 게시글 생성 이후에, Cache Data를 삭제하여 Cache Hit의 경우에만 다시 불러올 수 있도록 구성
    @Transactional
    public void createBoard(BoardDto dto) {
        String key = BOARD_KEY + dto.getNum();

        // * 1. Database 삽입 작업 진행
        this.boardRepository.save(dto.toEntity());

        // * 2. Cache Data 삭제
        this.redisOperator.delete(key);
    }

    @Transactional
    public void editBoard(Long id, BoardDto dto) {
        String key = BOARD_KEY + id;

        // * 1. Database 갱신 작업 수행
        this.boardRepository.updateBoard(dto.toEntity(id));

        // * 2. Cache Data 삭제
        this.redisOperator.delete(key);
    }

    @Transactional
    public void removeBoard(Long id) {
        String key = BOARD_KEY + id;
        
        // * 1. Database 삭제 작업 진행
        this.boardRepository.deleteById(id);

        // * 2. 존재하고 있는 Cache Data 삭제
        this.redisOperator.delete(key);
    }
}
