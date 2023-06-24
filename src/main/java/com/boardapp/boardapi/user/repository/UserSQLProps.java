package com.boardapp.boardapi.user.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:sql/user/user.xml")
@PropertySource("classpath:sql/user/address.xml")
@ConfigurationProperties(prefix = "user")
@Getter
@Setter
public class UserSQLProps {
    private String SELECT_ALL;
    private String SELECT_BY_USER_ID;

    private String INSERT_USER;
    private String INSERT_ADDRESS;

    private String UPDATE_USER_BY_USER_ID;
    private String UPDATE_ADDRESS_BY_USER_ID;

    private String DELETE_BY_USER_ID;
}
