package com.boardapp.boardapi.user.repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.repository.sql.UserSql;

public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserCustomRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<User> findAllUser() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllUser'");
    }

    @Override
    public User findByUserId(String userId) {
        throw new UnsupportedOperationException("Unimplemented method 'findByUserId'");
    }

    @Override
    public Integer saveBoard(User user) {
        String sql = UserSql.INSERT_USER;

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(user);

        return this.namedParameterJdbcTemplate.update(sql, namedParameterSource);
    }

    @Override
    public Integer updateBoard(User user, String userId) {
        String sql = UserSql.UPDATE_BY_ID;

        user.setUserId(userId);

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(user);

        return this.namedParameterJdbcTemplate.update(sql, namedParameterSource);
    }

}
