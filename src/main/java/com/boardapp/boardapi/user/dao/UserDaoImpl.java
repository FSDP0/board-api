package com.boardapp.boardapi.user.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.model.User;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

@Repository("userDao")
@RequiredArgsConstructor
public class UserDaoImpl  implements UserDao {
    // ! SqlSession dependency injection
    @Resource(name="readSqlSessionTemplate")
    private final SqlSession readSqlSession;

    @Resource(name="cudSqlSessionTemplate")
    private final SqlSession cudSqlSession;
    // !

    private final String findAllUser    = "com.boardapp.boardapi.user.mapper.UserReadMapper.getAllUser";
    private final String findByUserId   = "com.boardapp.boardapi.user.mapper.UserReadMapper.getByUserId";
    private final String save       = "com.boardapp.boardapi.user.mapper.UserCudMapper.saveUser";
    private final String update     = "com.boardapp.boardapi.user.mapper.UserCudMapper.updateUser";
    private final String delete     = "com.boardapp.boardapi.user.mapper.UserCudMapper.deleteUser";

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
        this.cudSqlSession.insert(save, user);
    }

    @Override
    public void updateUser(User user) {
        this.cudSqlSession.update(update, user);
    }

    @Override
    public void deleteUser(String userId) {
        this.cudSqlSession.delete(delete,userId);
    }

}
