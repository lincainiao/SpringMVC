package com.lin.service;

import com.lin.dao.UserMapper;
import com.lin.pojo.User;
import com.lin.utils.MybatisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.security.cert.CRLReason;
import java.util.Map;

public class LoginUser {
    private static ApplicationContext context;
    private static UserMapper userMapper;
    static {
        context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        userMapper = context.getBean("getUserMapper", UserMapper.class);
    }
    public static User getLoginUser(Map<String,Object> map){
        User user = userMapper.getUser(map);
        return user;
    }
}
