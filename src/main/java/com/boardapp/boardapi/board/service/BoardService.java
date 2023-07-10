package com.boardapp.boardapi.board.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boardapp.boardapi.board.entity.Board;
import com.boardapp.boardapi.board.model.BoardDto;
import com.boardapp.boardapi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Cacheable(
        value = "boards",
        cacheNames = "boardList",
        cacheManager = "boardCacheManager")
    public List<BoardDto> getAllBoards() {
        log.warn("Cache data not found ...");

        log.info("Request data ...");

        Iterable<Board> boardList = this.boardRepository.findAll();

        List<BoardDto> dtoList = new ArrayList<BoardDto>();

        for (Board board : boardList) {
            dtoList.add(board.toDto());
        }

        return dtoList;
    }

    @Cacheable(value = "boards", key = "#id", cacheManager = "boardCacheManager")
    public BoardDto getByBoardId(Long id) {
        log.warn("No Cache");

        return this.boardRepository.findById(id).get().toDto();
    }

    @Transactional
    @CachePut(value = "boards", key = "#dto?.num")
    public Board saveBoard(BoardDto dto) {
        return this.boardRepository.save(dto.toEntity());
    }

    @Transactional
    @Caching(evict = @CacheEvict(value = "boards", key = "#id"), put = @CachePut(value = "boards", key = "#id"))
    public void updateBoard(Long id, BoardDto dto) {
        this.boardRepository.updateBoard(dto.toEntity(id));
    }

    @Transactional
    @CacheEvict(value = "boards", key = "#id", beforeInvocation = false) // ! 메소드 실행 이후에 CacheEvict
    public void deleteBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
