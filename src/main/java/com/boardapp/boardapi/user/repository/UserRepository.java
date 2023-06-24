package com.boardapp.boardapi.user.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapp.boardapi.user.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final UserSQLProps userSQLProps;

    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserRepository(JdbcTemplate jdbcTemplate, UserSQLProps userSQLProps) {
        this.jdbcTemplate = jdbcTemplate;
        this.userSQLProps = userSQLProps;
    }

    public List<User> findAllUsers() {
        log.info("\\... Repository");

        String sql = userSQLProps.getSELECT_ALL();

        log.info("\n[ Sending SQL Query ]" + sql);

        return this.jdbcTemplate.query(sql, userRowMapper);
    }

    public User findUserById(String userId) {
        log.info("\\... Repository");

        String sql = userSQLProps.getSELECT_BY_USER_ID();

        log.info("\n[ Sending SQL Query ]" + sql);

        return this.jdbcTemplate.queryForObject(sql, userRowMapper, userId);
    }

    public void saveUser(User user) {
        log.info("\\... Repository");

        String userSql = userSQLProps.getINSERT_USER();
        String addressSql = userSQLProps.getINSERT_ADDRESS();

        log.info("\n[ Sending SQL Query ]" + userSql);
        log.info("\n[ Sending SQL Query ]" + addressSql);

        this.jdbcTemplate.update(userSql, user.getUserId(), user.getUserName(),
                user.getUserPassword(), user.getUserTel(), LocalDateTime.now());

        this.jdbcTemplate.update(addressSql, user.getUserId(), user.getUserAddress(),
                user.getAddressZipcode());
    }

    public void editUser(String userId, User user) {
        log.info("\\... Repository");

        String userSql = userSQLProps.getUPDATE_USER_BY_USER_ID();
        String addressSql = userSQLProps.getUPDATE_ADDRESS_BY_USER_ID();

        log.info("\n[ Sending SQL Query ]" + userSql);
        log.info("\n[ Sending SQL Query ]" + addressSql);

        this.jdbcTemplate.update(userSql, user.getUserName(), user.getUserPassword(),
                user.getUserTel(), LocalDateTime.now(), userId);

        this.jdbcTemplate.update(addressSql, user.getUserAddress(), user.getAddressZipcode(),
                userId);
    }

    public void deleteUser(String userId) {
        log.info("\\... Repository");

        String sql = userSQLProps.getDELETE_BY_USER_ID();

        log.info("\n[ Sending SQL Query ]" + sql);

        this.jdbcTemplate.update(sql, userId);
    }
}
