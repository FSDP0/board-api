package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private final BoardRepository boardRepository;

    private final RedisOperator<BoardDto> redisOperator;

    private static String BOARD_KEY = "BOARD:NUM";

    public List<BoardDto> getAllBoards() {
        List<BoardDto> dtoList = this.redisOperator.getListValue(BOARD_KEY);
        
        if(dtoList == null) {
            List<BoardDto> dtoRepoList = new ArrayList<BoardDto>();
            
            Iterable<Board> boardList = this.boardRepository.findAll();
            
            for (Board board : boardList) {
                dtoRepoList.add(board.toDto());
            }

            redisOperator.setList(BOARD_KEY, dtoRepoList, Long.valueOf(10), TimeUnit.SECONDS);

            return dtoRepoList;
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

    @Transactional
    public void createBoard(BoardDto dto) {
        String key = BOARD_KEY + dto.getNum();

        this.redisOperator.set(key,dto,Long.valueOf(10),TimeUnit.SECONDS);

        this.boardRepository.save(dto.toEntity());
    }

    @Transactional
    public void editBoard(Long id, BoardDto dto) {
        String key = BOARD_KEY + id;

        this.redisOperator.delete(key);

        this.redisOperator.set(key, dto, Long.valueOf(10), TimeUnit.SECONDS);

        this.boardRepository.updateBoard(dto.toEntity(id));
    }

    @Transactional
    public void removeBoard(Long id) {
        String key = BOARD_KEY + id;

        this.redisOperator.delete(key);

        this.boardRepository.deleteById(id);
    }
}
