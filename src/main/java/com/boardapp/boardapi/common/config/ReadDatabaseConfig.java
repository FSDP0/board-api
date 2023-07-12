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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableTransactionManagement
@RequiredArgsConstructor
public class ReadDatabaseConfig {
    private final ApplicationContext applicationContext;

    @Primary
    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.read-only")
    DataSource readDataSource() {
        return DataSourceBuilder.create().build();
    }

    // @Primary
    // @Bean(name="readTransactionManager")
    // public PlatformTransactionManager readTransactionManager(@Qualifier("readDataSource") DataSource readDataSource) {
    //     return new DataSourceTransactionManager(readDataSource);
    // }

    @Primary
    @Bean(name = "readSqlSessionFactory")
    SqlSessionFactory readSqlSessionFactory(@Qualifier("readDataSource") DataSource readDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(readDataSource);

        // Set base package alias path
        // sqlSessionFactoryBean.setTypeAliasesPackage("com.boardapp.boardapi");
        // MyBatis XML mapper resource file path
        sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResources("classpath:mybatis/mapper/read/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "readSqlSessionTemplate")
    public SqlSessionTemplate readSqlSessionTemplate(SqlSessionFactory readSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(readSqlSessionFactory);
    }

    // ! Datasource initializer (resources 디렉토리에 존재하는 .sql script를 사용)
    @Primary
    @Bean(name = "readDataSourceScriptDatabaseInitializer")
    DataSourceInitializer readDataSourceInitializer(@Qualifier("readDataSource") DataSource readDataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();

        // ! Schema 생성 스크립트 추가 후에 Data 생성 스크립트를 추가 (순서 중요)
        resourceDatabasePopulator.addScript(this.applicationContext.getResource("classpath:database/schema-mysql.sql"));
        resourceDatabasePopulator.addScript(this.applicationContext.getResource("classpath:database/data-mysql.sql"));

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();

        // * DataSourceInitializer에서 사용할 DataSource 설정
        dataSourceInitializer.setDataSource(readDataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);

        return dataSourceInitializer;
    }
}
