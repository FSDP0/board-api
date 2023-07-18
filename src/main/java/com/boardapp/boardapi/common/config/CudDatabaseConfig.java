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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableTransactionManagement
@RequiredArgsConstructor
public class CudDatabaseConfig {
    private final ApplicationContext applicationContext;

    @Bean(name="cudDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cud-only")
    DataSource cudDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cudTransactionManager")
    PlatformTransactionManager cudTransactionManager(@Qualifier("cudDataSource") DataSource cudDataSource) {
        return new DataSourceTransactionManager(cudDataSource);
    }

    @Bean(name="cudSqlSessionFactory")
    SqlSessionFactory cudSqlSessionFactory(@Qualifier("cudDataSource") DataSource cudDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(cudDataSource);

        sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResources("classpath:mapper/cud/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="cudSqlSessionTemplate")
    SqlSessionTemplate cudSqlSessionTemplate(@Qualifier("cudSqlSessionFactory") SqlSessionFactory cudSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(cudSqlSessionFactory);
    }
}