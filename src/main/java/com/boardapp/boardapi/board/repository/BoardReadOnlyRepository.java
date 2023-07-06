package com.boardapp.boardapi.board.repository;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import com.boardapp.boardapi.common.config.CudOnlyDatabaseConfig;
import com.boardapp.boardapi.common.config.ReadOnlyDatabaseConfig;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardReadOnlyRepository {
    public final ReadOnlyDatabaseConfig readOnlyDatabaseConfig;
    public final CudOnlyDatabaseConfig cudOnlyDatabaseConfig;

    public void test() {
    }
}
