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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import lombok.RequiredArgsConstructor;

@Configuration
// ! Mapper JAVA file package path / 서로 다른 패키지 경로 명을 기준으로 탐색
// @MapperScan(value = "com.boardapp.boardapi.**.mapper.slave", sqlSessionFactoryRef = "slaveSqlSessionFactory")
@EnableTransactionManagement
@RequiredArgsConstructor
public class CudDatabaseConfig {
    private final ApplicationContext applicationContext;

    @Bean(name = "cudDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cud-only")
    public DataSource cudDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cudSqlSessionFactory")
    SqlSessionFactory cudSqlSessionFactory(@Qualifier("cudDataSource") DataSource cudDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(cudDataSource);

        // Set base package alias path
        // sqlSessionFactoryBean.setTypeAliasesPackage("com.boardapp.boardapi");
        // MyBatis XML mapper resource file path
        sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResources("classpath:mybatis/mapper/cud/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "cudSqlSessionTemplate")
    SqlSessionTemplate cudSqlSessionTemplate(SqlSessionFactory cudSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(cudSqlSessionFactory);
    }
}
