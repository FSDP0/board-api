package com.boardapp.boardapi.user.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> findAllUsers() {
        log.info("\\... Repository");

        String sql = UserSql.SELECT_ALL;

        log.info("\n[ Sending SQL Query ]\n" + sql);

        return this.namedParameterJdbcTemplate.query(sql, userRowMapper);
    }

    public User findUserById(String userId) {
        log.info("\\... Repository");

        String sql = UserSql.SELECT_BY_USER_ID;

        SqlParameterSource namedParameter = new MapSqlParameterSource("userId", userId);

        log.info("\n[ Sending SQL Query ]\n" + sql);

        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameter, userRowMapper);
    }

    public void saveUser(User user) {
        log.info("\\... Repository");

        user.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));

        String userSql = UserSql.INSERT_USER;
        String addressSql = AddressSql.INSERT_ADDRESS;

        log.info("\n[ Sending SQL Query ]\n" + userSql);
        log.info("\n[ Sending SQL Query ]\n" + addressSql);

        SqlParameterSource userNamedParameterSource = new BeanPropertySqlParameterSource(user);
        this.namedParameterJdbcTemplate.update(userSql, userNamedParameterSource);

        SqlParameterSource addressNamedParameterSource = new BeanPropertySqlParameterSource(user);
        this.namedParameterJdbcTemplate.update(addressSql, addressNamedParameterSource);
    }

    public void editUser(String userId, User user) {
        log.info("\\... Repository");

        String userSql = UserSql.UPDATE_USER_BY_USER_ID;
        String addressSql = AddressSql.UPDATE_ADDRESS_BY_USER_ID;

        log.info("\n[ Sending SQL Query ]\n" + userSql);
        log.info("\n[ Sending SQL Query ]\n" + addressSql);

        user.setUserId(userId);
        user.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));

        SqlParameterSource userNamedParameterSource = new BeanPropertySqlParameterSource(user);
        this.namedParameterJdbcTemplate.update(userSql, userNamedParameterSource);

        SqlParameterSource addressNamedParameterSource = new BeanPropertySqlParameterSource(user);
        this.namedParameterJdbcTemplate.update(addressSql, addressNamedParameterSource);
    }

    public void deleteUser(String userId) {
        log.info("\\... Repository");

        String SQL = UserSql.DELETE_BY_USER_ID;

        log.info("\n[ Sending SQL Query ]\n" + SQL);

        SqlParameterSource namedParameter = new MapSqlParameterSource("userId", userId);

        this.namedParameterJdbcTemplate.update(SQL, namedParameter);
    }
}
