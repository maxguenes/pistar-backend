package com.pistar.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by maxguenes on 25/06/2017.
 */
@Configuration
@MapperScan( value = "com.pistar.jpa.mapper")
public class DatabaseConfig {


    @Bean
    @Primary
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();

        ds.setDriverClassName("org.h2.Driver");
        ds.setJdbcUrl("jdbc:h2:file:./data/pistar");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.addDataSourceProperty("cachePrepStmts", "true");
        ds.addDataSourceProperty("prepStmtCacheSize", "300");
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return ds;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.pistar.jpa.model");
        return sessionFactory;
    }
}
