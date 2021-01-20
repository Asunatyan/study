package com.dqk.test.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * apicenter数据源
 */
@Configuration
@MapperScan(basePackages = {"com.dqk.test.**.mapper", "com.dqk.test.**.mapper"}, sqlSessionFactoryRef = "apicenterSqlSessionFactory")
public class ApicenterDataSourceConfig {

    @Autowired
    private ApicenterDbInfo apicenterDbInfo;

    @Bean(name = "apicenterDataSource")
    public HikariDataSource druidDataSource() {
        HikariDataSource dds = new HikariDataSource();
        dds.setJdbcUrl(apicenterDbInfo.getUrl());
        dds.setUsername(apicenterDbInfo.getUsername());
        dds.setPassword(apicenterDbInfo.getPassword());
        dds.setDriverClassName(apicenterDbInfo.getDriverClassName());
        return dds;
    }

    @Bean(name = "apicenterTransactionManager")
    public DataSourceTransactionManager apicenterTransactionManager(DataSource apicenterDataSource) {
        return new DataSourceTransactionManager(apicenterDataSource);
    }

    @Bean(name = "apicenterSqlSessionFactory")
    public SqlSessionFactory apicenterSqlSessionFactory(DataSource apicenterDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(apicenterDataSource);
        PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources1 = resourceResolver.getResources("classpath*:mapper/**/*.xml");
        Resource[] resources2 = resourceResolver.getResources("classpath*:mapper/**/*.xml");
        Resource[] resources = Arrays.copyOf(resources1, resources1.length + resources2.length);
        System.arraycopy(resources2, 0, resources, resources1.length, resources2.length);
        sessionFactory.setMapperLocations(resources);
        sessionFactory.setConfigLocation(resourceResolver.getResource("classpath:mybatis-config.xml"));
        return sessionFactory.getObject();
    }

}
