package com.boardapp.boardapi.common.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ReadDatabaseConfig {
    private final ApplicationContext applicationContext;

    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.read-only")
    @Bean(name = "readDataSource")
    DataSource readDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "readSqlSessionFactory")
    SqlSessionFactory readSqlSessionFactory(@Qualifier("readDataSource") DataSource readDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(readDataSource);

        sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResources("classpath:mapper/read/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name="readSqlSessionTemplate")
    SqlSessionTemplate readSqlSessionTemplate(@Qualifier("readSqlSessionFactory") SqlSessionFactory readSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(readSqlSessionFactory);
    }
}
