package com.boardapp.boardapi.common.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching // ! This annotation using for activate cache annocations
public class CachingConfig {
    @Bean
    CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("boards");

        cacheManager.setAllowNullValues(false); // ! Occured error when caching null value

        return cacheManager;
    }
}
