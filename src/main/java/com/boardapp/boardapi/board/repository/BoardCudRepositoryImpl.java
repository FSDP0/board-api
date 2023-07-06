package com.boardapp.boardapi.board.repository;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import com.boardapp.boardapi.board.model.Board;
import com.boardapp.boardapi.common.config.CudDatabaseConfig;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardCudRepositoryImpl implements BoardCudRepository{
    private final CudDatabaseConfig cudOnlyDatabaseConfig;


    @Override
    public void saveBoard(Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveBoard'");
    }

    @Override
    public void updateBoard(Long boardId, Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBoard'");
    }

    @Override
    public void deleteBoard(Long boardId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }
}
