package com.boardapp.boardapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.repository.sql.UserJPQL;
import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, String> {
    @Modifying
    @Transactional
    @Query(value = UserJPQL.UPDATE_BY_ID)
    Integer updateUser(@Param("userObj") User user);
}
