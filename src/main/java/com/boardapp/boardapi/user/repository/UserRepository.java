package com.boardapp.boardapi.user.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.repository.sql.UserSQL;

public interface UserRepository extends CrudRepository<User, String> {
    @Query(value = UserSQL.SELECT_ALL)
    public List<User> findAllUser();

    @Query(value = UserSQL.SELECT_BY_ID)
    public User findUserById(@Param("id") String userId);

    @Query(value = UserSQL.INSERT_USER)
    public User saveUser();

    @Modifying
    @Query(value = UserSQL.UPDATE_BY_ID)
    public void updateUser(@Param("name") String name, @Param("password") String password,
            @Param("tel") String tel, @Param("address") String address,
            @Param("zipcode") String zipcode, @Param("id") String id);

    @Query(value = UserSQL.SELECT_ALL_TEST)
    public Iterable<Object> sample();
}
