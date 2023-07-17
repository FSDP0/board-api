package com.boardapp.boardapi.user.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.model.User;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserCudDaoImpl implements UserCudDao {
    @Resource(name = "cudSqlSessionTemplate")
    private final SqlSessionTemplate sqlSessionTemplate;

    private final static String NAMESPACE = "UserCudDao";

    @Override
    public Integer saveUser(User user) {
        return this.sqlSessionTemplate.insert(NAMESPACE + ".saveUser", user);
    }

    @Override
    public Integer updateUser(User user) {
        return this.sqlSessionTemplate.update(NAMESPACE + ".updateUser", user);
    }

    @Override
    public Integer deleteUser(String userId) {
        return this.sqlSessionTemplate.delete(NAMESPACE + ".deleteUser", userId);
    }

}
