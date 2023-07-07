package com.boardapp.boardapi.user.repository;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.boardapp.boardapi.user.entity.User;
import com.boardapp.boardapi.user.repository.sql.UserSql;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository{
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void saveUser(User user) {
        String sql = UserSql.INSERT_USER;

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(user);

        this.namedParameterJdbcTemplate.update(sql, namedParameterSource);
    }

    @Override
    public void updateUser(User user) {
        String sql = UserSql.UPDATE_BY_ID;

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(user);

        this.namedParameterJdbcTemplate.update(sql, namedParameterSource);
    }
    
}
