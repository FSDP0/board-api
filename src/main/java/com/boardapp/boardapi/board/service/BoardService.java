package com.boardapp.boardapi.board.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.common.mapper.master.MasterDatabaseMapper;

@Service
public class BoardService {
    private final MasterDatabaseMapper masterDatabaseMapper;

    public BoardService(MasterDatabaseMapper masterDatabaseMapper) {
        this.masterDatabaseMapper = masterDatabaseMapper;
    }

    public List<Board> getBoards() throws Exception {
        return masterDatabaseMapper.getAllBoards();
    }
}
