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
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// Mapper JAVA file package path / 서로 다른 패키지 경로 명을 가져야 함
@MapperScan(value = "com.boardapp.boardapi.common.mapper.slave", sqlSessionFactoryRef = "slaveSqlSessionFactory")
@EnableTransactionManagement
public class SlaveDatabaseConfig {
    private final ApplicationContext applicationContext;

    public SlaveDatabaseConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveSqlSessionFactory")
    SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(slaveDataSource);

        // MyBatis XML mapper resource file path
        sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResources("classpath:mybatis/mapper/slave/slave-mapper.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "slaveSqlSessionTemplate")
    SqlSessionTemplate slaveSqlSessionTemplate(SqlSessionFactory slaveSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(slaveSqlSessionFactory);
    }
}
