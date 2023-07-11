package com.boardapp.boardapi.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableRedisRepositories
public class RedisConfig {
    @Value("${sub.test}")
    private String TEST_VALUE;

    // ! Get Redis Host Name from environment values
    @Value("${spring.data.redis.host}")
    private String REDIS_HOST;

    // ! Get Redis Port Number from environment values
    @Value("${spring.data.redis.port}")
    private Integer REDIS_PORT;

    public RedisConfig(){
        log.info("Redis Host : {}", REDIS_HOST);
        log.info("Redis Port : {}", REDIS_PORT);
        log.info("Test Value : {}", TEST_VALUE);
    }

    // // ! Redis connection factory
    // @Bean
    // public RedisConnectionFactory redisConnectionFactory(){
    // return new LettuceConnectionFactory(REDIS_HOST, REDIS_PORT);
    // }

    // // ! Redis connection returned byte data object serialization
    // @Bean
    // public RedisTemplate<?, ?> redisTemplate() {
    // RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();

    // redisTemplate.setConnectionFactory(redisConnectionFactory());

    // return redisTemplate;
    // }
}
