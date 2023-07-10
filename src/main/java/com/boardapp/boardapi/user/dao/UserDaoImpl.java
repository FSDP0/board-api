package com.boardapp.boardapi.user.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.model.User;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

@Repository("userDao")
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    // ! SqlSession dependency injection
    @Resource(name = "readSqlSessionTemplate")
    private final SqlSession readSqlSession;

    @Qualifier("cudSqlSessionTemplate")
    @Resource(name = "cudSqlSessionTemplate")
    private final SqlSession cudSqlSession;
    // !

    private final String findAllUser = "com.boardapp.boardapi.user.mapper.UserReadMapper.getAllUser";
    private final String findByUserId = "com.boardapp.boardapi.user.mapper.UserReadMapper.getByUserId";
    private final String saveUser = "com.boardapp.boardapi.user.mapper.UserCudMapper.saveUser";
    private final String updateUser = "com.boardapp.boardapi.user.mapper.UserCudMapper.updateUser";
    private final String deleteUser = "com.boardapp.boardapi.user.mapper.UserCudMapper.deleteUser";

    @Override
    public List<User> findAll() {
        List<User> userList = this.readSqlSession.selectList(findAllUser);

        return userList;
    }

    @Override
    public User findById(String userId) {
        User user = this.readSqlSession.selectOne(findByUserId, userId);

        return user;
    }

    @Override
    public void saveUser(User user) {
        this.cudSqlSession.insert("com.boardapp.boardapi.user.mapper.UserCudMapper.saveUser", user);
    }

    @Override
    public void updateUser(User user) {
        this.cudSqlSession.update(updateUser, user);
    }

    @Override
    public void deleteUser(String userId) {
        this.cudSqlSession.delete(deleteUser, userId);
    }

}
