// package com.boardapp.boardapi.common.config;

// import javax.sql.DataSource;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// import org.springframework.jdbc.datasource.init.DataSourceInitializer;
// import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;
// import lombok.RequiredArgsConstructor;

// @Configuration
// @EnableTransactionManagement
// @RequiredArgsConstructor
// public class DatabaseConfig {
//     // ! DI(Dependency Injection)
//     private final ApplicationContext applicationContext;

//     // ! DataSource 생성
//     @Bean
//     @ConfigurationProperties(prefix = "spring.datasource")
//     DataSource dataSource() {
//         return DataSourceBuilder.create().build();
//     }

//     // ! TransactionManager 설정
//     @Bean
//     PlatformTransactionManager transactionManager(DataSource dataSource) {
//         return new DataSourceTransactionManager(dataSource);
//     }

//     // ! SqlSession에 DataSource와 XML Mapper 경로 등록
//     @Bean
//     SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//         final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

//         sqlSessionFactoryBean.setDataSource(dataSource);

//         sqlSessionFactoryBean.setMapperLocations(this.applicationContext.getResources("classpath*:mapper/**/*.xml"));

//         return sqlSessionFactoryBean.getObject();
//     }

//     // ! SqlSessionTemplate 생성
//     @Bean
//     SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
//         return new SqlSessionTemplate(sqlSessionFactory);
//     }

//     // ! Database Initializer with SQL Script (Remove this bean on production environment)
//     @Bean
//     DataSourceInitializer readDataSourceInitializer(DataSource dataSource) {
//         ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();

//         // ! Schema 생성 스크립트 추가 후에 Data 생성 스크립트를 추가 (순서 중요)
//         resourceDatabasePopulator.addScript(this.applicationContext.getResource("classpath:database/schema-mysql.sql"));
//         resourceDatabasePopulator.addScript(this.applicationContext.getResource("classpath:database/data-mysql.sql"));

//         DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();

//         // * DataSourceInitializer에서 사용할 DataSource 설정
//         dataSourceInitializer.setDataSource(dataSource);
//         dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);

//         return dataSourceInitializer;
//     }
// }
