package com.boardapp.boardapi.user.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.user.entity.User;

public interface UserRepository extends CrudRepository<User, String>, UserCustomRepository {
    @Query(value = "SELECT * FROM user ORDER BY id ASC")
    List<User> findAllOrderByBoardId();
}
