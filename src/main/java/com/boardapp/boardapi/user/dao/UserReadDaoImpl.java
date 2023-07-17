package com.boardapp.boardapi.user.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.model.User;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserReadDaoImpl implements UserReadDao {
    @Resource(name = "readSqlSessionTemplate")
    private final SqlSessionTemplate sqlSessionTemplate;

    private static final String NAMESPACE = "UserReadDao";

    @Override
    public List<User> findAllUser() {
        return this.sqlSessionTemplate.selectList(NAMESPACE + ".findAllUser");
    }

    @Override
    public User findByUserId(String userId) {
        return this.sqlSessionTemplate.selectOne(NAMESPACE + ".findByUserId", userId);
    }

}
