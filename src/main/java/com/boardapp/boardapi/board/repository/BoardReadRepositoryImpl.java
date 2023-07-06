package com.boardapp.boardapi.board.repository;

import java.util.List;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.common.config.ReadDatabaseConfig;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardReadRepositoryImpl implements BoardReadRepository{
    private final ReadDatabaseConfig readDatabaseConfig;

    @Override
    public List<Board> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Board findByBoardId(Long boardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByBoardId'");
    }
}
