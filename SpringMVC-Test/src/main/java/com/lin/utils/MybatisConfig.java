package com.lin.utils;

import com.lin.dao.UserMapperImpl;
import com.lin.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class MybatisConfig {
    // 数据源
    @Bean
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        System.out.println("dataSource Done!");
        return dataSource;
    }
    // sqlFactoryBean
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        // mybatis-config.xml
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        Resource mybatisResource = new InputStreamResource(inputStream);
        sqlSessionFactoryBean.setConfigLocation(mybatisResource);
        // UserMapper.xml
        inputStream = Resources.getResourceAsStream("com/lin/dao/UserMapper.xml");
        Resource mapperConfig = new InputStreamResource(inputStream);
        sqlSessionFactoryBean.setMapperLocations(mapperConfig);
        System.out.println("sqlSessionFactory Done!");
        return sqlSessionFactoryBean;
    }
    //sqlSession
    @Bean
    public SqlSession getSqlSession() throws Exception {
        SqlSession sqlSession = getSqlSessionFactory().getObject().openSession(true);
        System.out.println("sqlSession Done!");
        return sqlSession;
    }

    //UserMapperImpl
    @Bean
    public UserMapperImpl getUserMapper() throws Exception {
        UserMapperImpl userMapper = new UserMapperImpl();
        userMapper.setSqlSession(getSqlSession());
        return userMapper;
    }
}
