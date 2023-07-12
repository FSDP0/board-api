package com.boardapp.boardapi.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableRedisRepositories
public class RedisConfig {
    // ! Get Redis Host Name from environment values
    @Value("${spring.data.redis.host}")
    private String REDIS_HOST = "localhost";

    // ! Get Redis Port Number from environment values
    @Value("${spring.data.redis.port}")
    private Integer REDIS_PORT = 6379;

    public RedisConfig(){
        log.info("Redis Host : {}", REDIS_HOST);
        log.info("Redis Port : {}", REDIS_PORT);
    }

    // ! Redis connection factory
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
    return new LettuceConnectionFactory(REDIS_HOST, REDIS_PORT);
    }

    // ! Redis connection returned byte data object serialization
    @Bean(name = "redisObjectTemplate")
    public RedisTemplate<?, ?> redisTemplate() {
    RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();

    redisTemplate.setConnectionFactory(redisConnectionFactory());

    return redisTemplate;
    }
}
