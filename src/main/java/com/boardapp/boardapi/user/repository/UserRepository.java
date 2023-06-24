package com.boardapp.boardapi.user.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.sql.AddressSql;
import com.boardapp.boardapi.user.sql.UserSql;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAllUsers() {
        log.info("\\... Repository");

        String sql = UserSql.SELECT_ALL;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        return this.jdbcTemplate.query(sql, userRowMapper);
    }

    public User findUserById(String userId) {
        log.info("\\... Repository");

        String sql = UserSql.SELECT_BY_USER_ID;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        return this.jdbcTemplate.queryForObject(sql, userRowMapper, userId);
    }

    public void saveUser(User user) {
        log.info("\\... Repository");

        String userSql = UserSql.INSERT_USER;
        String addressSQL = AddressSql.INSERT_ADDRESS;

        log.info("\n[ Sending SQL Query ]\n" + userSql);
        log.info("\n[ Sending SQL Query ]\n" + addressSQL);

        this.jdbcTemplate.update(userSql, user.getUserId(), user.getUserName(),
                user.getUserPassword(), user.getUserTel(), LocalDateTime.now());

        this.jdbcTemplate.update(addressSQL, user.getUserId(), user.getUserAddress(),
                user.getAddressZipcode());
    }

    public void editUser(String userId, User user) {
        log.info("\\... Repository");

        String userSql = UserSql.UPDATE_USER_BY_USER_ID;
        String addressSql = AddressSql.UPDATE_ADDRESS_BY_USER_ID;

        log.info("\n[ Sending SQL Query ]\n" + userSql);
        log.info("\n[ Sending SQL Query ]\n" + addressSql);

        this.jdbcTemplate.update(userSql, user.getUserName(), user.getUserPassword(),
                user.getUserTel(), LocalDateTime.now(), userId);

        this.jdbcTemplate.update(addressSql, user.getUserAddress(), user.getAddressZipcode(),
                userId);
    }

    public void deleteUser(String userId) {
        log.info("\\... Repository");

        String sql = UserSql.DELETE_BY_USER_ID;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        this.jdbcTemplate.update(sql, userId);
    }
}
