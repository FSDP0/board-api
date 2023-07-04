package com.boardapp.boardapi.common.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// ! Mapper JAVA file path / 서로 다른 패키지 경로 명을 기준으로 탐색
@MapperScan(value = "com.boardapp.boardapi.common.mapper.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
@EnableTransactionManagement
public class MasterDatabaseConfig {
    private final ApplicationContext applicationContext;

    public MasterDatabaseConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Primary
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "masterSqlSessionFactory")
    SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(masterDataSource);

        // MyBatis XML mapper resource file path
        sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResource("classpath:mybatis/mapper/master/master-mapper.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "masterSqlSessionTemplate")
    SqlSessionTemplate masterSqlSessionTemplate(SqlSessionFactory masterSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(masterSqlSessionFactory);
    }

    // ! Datasource initializer (resources 디렉토리에 존재하는 .sql script를 사용)
    @Primary
    @Bean(name = "masterDataSourceScriptDatabaseInitializer")
    DataSourceInitializer masterDataSourceInitializer(@Qualifier("masterDataSource") DataSource masterDataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();

        // ! Schema 생성 스크립트 추가 후에 Data 생성 스크립트를 추가 (순서 중요)
        resourceDatabasePopulator.addScript(this.applicationContext.getResource("classpath:database/master/schema-master.sql"));
        resourceDatabasePopulator.addScript(this.applicationContext.getResource("classpath:database/master/data-master.sql"));

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();

        // * DataSourceInitializer에서 사용할 DataSource 설정
        dataSourceInitializer.setDataSource(masterDataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);

        return dataSourceInitializer;
    }
}
