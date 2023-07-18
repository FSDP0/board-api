package com.boardapp.boardapi.user.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.model.User;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private final SqlSessionTemplate sqlSessionTemplate;

    private static final String NAMESPACE = "UserDao";

    @Override
    public List<User> findAllUser() {
        return this.sqlSessionTemplate.selectList(NAMESPACE + ".findAllUser");
    }

    @Override
    public User findByUserId(String userId) {
        return this.sqlSessionTemplate.selectOne(NAMESPACE + ".findByUserId", userId);
    }

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
