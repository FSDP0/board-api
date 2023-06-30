package com.boardapp.boardapi.board.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.common.mapper.master.MasterDatabaseMapper;
import com.boardapp.boardapi.common.mapper.slave.SlaveDatabaseMapper;

@Service
public class BoardService {
    private final MasterDatabaseMapper masterDatabaseMapper;
    private final SlaveDatabaseMapper slaveDatabaseMapper;

    public BoardService(MasterDatabaseMapper masterDatabaseMapper, SlaveDatabaseMapper slaveDatabaseMapper) {
        this.masterDatabaseMapper = masterDatabaseMapper;
        this.slaveDatabaseMapper = slaveDatabaseMapper;
    }

    public List<Board> getAllBoards() throws Exception {
        return this.masterDatabaseMapper.getAllBoards();
    }
}
